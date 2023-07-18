package com.study.springvueapiboard.backend.repositories;

import com.study.springvueapiboard.backend.dtos.FileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The type File repository.
 */
@Repository
@RequiredArgsConstructor
public class FileRepository {

    private final FileMapper fileMapper;

    /**
     * 파일 목록을 반환해주는 메서드
     *
     * @param boardId 게시글 Id
     * @return List<File>     파일 List
     */
    public List<FileDto> getFileList(int boardId) {
        return fileMapper.getFileList(boardId);
    }

    /**
     * 파일 정보를 db에 저장하는 메서드
     *
     * @param fileDto 파일 Dto
     */
    public void postFile(FileDto fileDto) {
        fileMapper.postFile(fileDto);
    }

    /**
     * 파일Id로 파일 정보를 조회하는 메서드
     *
     * @param fileId 파일 Id
     * @return the file
     */
    public FileDto getFile(int fileId) {
        return fileMapper.getFile(fileId);
    }
}