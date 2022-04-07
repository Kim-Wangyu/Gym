package com.gym.s1.board.notice;

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
public class NoticeService implements BoardService{
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired 
	private FileManager fileManager;
	
	
	public int fileDelete(BoardFileDTO boardFileDTO)throws Exception{
		return noticeDAO.fileDelete(boardFileDTO);
	}

	@Override
	public int add(BoardDTO boardDTO, MultipartFile[] files) throws Exception {
		// TODO Auto-generated method stub
		int result = noticeDAO.add(boardDTO);
		
		//1. HDD에 저장
		for(int i =0;i<files.length;i++) {
			if(files[i].isEmpty()) {
				//files[i].getSize()==0 과 같냐고 물어보는것
				continue;
			}
			String fileName=fileManager.save(files[i], "resources/upload/notice/");
		//2. DB에 저장
			NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
			noticeFileDTO.setNum(boardDTO.getNum());
			noticeFileDTO.setFileName(fileName);
			noticeFileDTO.setOriName(files[i].getOriginalFilename());
			result=noticeDAO.addFile(noticeFileDTO);
		}
		
		return result;
	}

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		pager.makeNum();
		pager.makePageNum(noticeDAO.total(pager));
		return noticeDAO.list(pager);
	}
	//------------
	@Override
	public List<BoardDTO> list2(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		pager.makeNum();
		pager.makePageNum(noticeDAO.total(pager));
		pager.setStartNum(1L);
		pager.setLastNum(5L);
		return noticeDAO.list(pager);
	}
	//---------------

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		boardDTO =noticeDAO.detail(boardDTO);
		return boardDTO;
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		int result = noticeDAO.delete(boardDTO);
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO, MultipartFile[] files) throws Exception {
		// TODO Auto-generated method stub
		int result = noticeDAO.update(boardDTO);
		
		for(int i =0;i<files.length;i++) {
			if(files[i].isEmpty()) {
				continue;
			}
			String fileName = fileManager.save(files[i], "resources/upload/notice/");
			
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setNum(boardDTO.getNum());
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(files[i].getOriginalFilename());
			result = noticeDAO.addFile(boardFileDTO);
		
		}
		return result;
	}

}
