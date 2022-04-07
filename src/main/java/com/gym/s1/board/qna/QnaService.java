package com.gym.s1.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gym.s1.board.BoardDTO;
import com.gym.s1.board.BoardFileDTO;
import com.gym.s1.board.BoardService;
import com.gym.s1.board.notice.NoticeDAO;
import com.gym.s1.util.FileManager;
import com.gym.s1.util.Pager;

@Service
public class QnaService implements BoardService{
	
	@Autowired
	private QnaDAO qnaDAO;
	@Autowired
	private FileManager fileManager;
	
	public int fileDelete(BoardFileDTO boardFileDTO)throws Exception{
		
		return qnaDAO.fileDelete(boardFileDTO);
	}
	
	public int add(BoardDTO boardDTO,MultipartFile[] files) throws Exception{
		int result =  qnaDAO.add(boardDTO);
		
			for(int i=0;i<files.length;i++) {
				if(files[i].isEmpty()) {
					continue;
				}
				String filename = fileManager.save(files[i], "resources/upload/qna/");
				
				QnaFileDTO qnaFileDTO = new QnaFileDTO();
				qnaFileDTO.setNum(boardDTO.getNum());
				qnaFileDTO.setFileName(filename);
				qnaFileDTO.setOriName(files[i].getOriginalFilename());
				result = qnaDAO.addFile(qnaFileDTO);
			}
		
		
		return result;
	}
	
	
	public List<BoardDTO> list2(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		pager.makeNum();
		pager.makePageNum(qnaDAO.total(pager));
		pager.setStartNum(1L);
		pager.setLastNum(5L);
		return qnaDAO.list(pager);
	}
	
	public List<BoardDTO> list(Pager pager) throws Exception{
		pager.makeNum();
		pager.makePageNum(qnaDAO.total(pager));
		List<BoardDTO>ar = qnaDAO.list(pager);
		return ar;
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		
		return qnaDAO.detail(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.delete(boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO,MultipartFile[] files) throws Exception {
		// TODO Auto-generated method stub
		int result = qnaDAO.update(boardDTO);
		
		for(int i=0;i<files.length;i++) {
			if(files[i].isEmpty()) {
				continue;
			}
			String filename = fileManager.save(files[i], "resources/upload/qna/");
			
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setNum(boardDTO.getNum());
			boardFileDTO.setFileName(filename);
			boardFileDTO.setOriName(files[i].getOriginalFilename());
			result = qnaDAO.addFile(boardFileDTO);
		}
		
		return result;

	}
	

	

}
