package com.gym.s1.board.exercise;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gym.s1.board.BoardDTO;
import com.gym.s1.board.BoardFileDTO;
import com.gym.s1.board.BoardService;
import com.gym.s1.util.FileManager;
import com.gym.s1.util.Pager;
@Service
public class ExerciseService implements BoardService {
	
	@Autowired
	private ExerciseDAO exerciseDAO;
	@Autowired
	private FileManager fileManager;
	
	public int deleteFile(ExerciseFileDTO exerciseFileDTO)throws Exception{
		int result=exerciseDAO.deleteFile(exerciseFileDTO);
		return result;
	}
	
	@Override
	public int add(BoardDTO boardDTO,MultipartFile[] files) throws Exception {
		int result=exerciseDAO.add(boardDTO);
		
		//1.HDD에 저장
		for(int i=0;i<files.length;i++) { 
			if(files[i].isEmpty()){
				//files[i].getsize()가 0과 같습니까 
				continue;
			}
			String fileName = fileManager.save(files[i], "resources/upload/exercise/");
			
			//2. DB에 저장
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setNum(boardDTO.getNum());
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(files[i].getOriginalFilename());
			
			result=exerciseDAO.addFile(boardFileDTO);
		}
		return result;
	}
	
	@Override
	public List<BoardDTO> list2(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		pager.makeNum();
		pager.makePageNum(exerciseDAO.total(pager));
		pager.setStartNum(1L);
		pager.setLastNum(5L);
		return exerciseDAO.list(pager);
	}

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		pager.makeNum();
		pager.makePageNum(exerciseDAO.total(pager));
		return exerciseDAO.list(pager);
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		return exerciseDAO.detail(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		return exerciseDAO.delete(boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO,MultipartFile[] files) throws Exception {
		int result=exerciseDAO.update(boardDTO);
		
		for(int i=0;i<files.length;i++) { 
			if(files[i].isEmpty()){
				//files[i].getsize()가 0과 같습니까 
				continue;
			}
			String fileName = fileManager.save(files[i], "resources/upload/exercise/");
			
			//2. DB에 저장
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setNum(boardDTO.getNum());
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(files[i].getOriginalFilename());
	
			result=exerciseDAO.addFile(boardFileDTO);
		}
		return result;
	}
	
}
