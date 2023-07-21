package com.study.springvueapiboard.backend.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * 게시글 수정에 사용되는 DTO 클래스입니다.
 *
 * 이 DTO 클래스는 게시글의 수정에 필요한 정보를 담고 있으며, 다음과 같은 필드들을 가지고 있습니다:
 * - Integer boardId: 게시글 ID
 * - String writer: 작성자
 * - String password: 비밀번호
 * - String title: 제목
 * - String content: 내용
 * - MultipartFile[] files: 파일
 * - List<Integer> deleteFileIdList: 삭제할 파일 ID 목록
 */
@Getter
@Setter
@NoArgsConstructor
public class BoardUpdateRequestDto {

    private Integer boardId; // 게시글 Id

    @NotBlank(message = "작성자는 필수 항목입니다.")
    @Size(min = 3, max = 4, message = "작성자는 3글자 이상 5글자 미만이어야 합니다.")
    private String writer;

    @NotBlank(message = "비밀번호는 필수 항목입니다.")
    @Size(min = 4, max = 16, message = "비밀번호는 4글자 이상 16글자 미만이어야 합니다.")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]*$",
            message = "비밀번호는 영어, 숫자, 특수문자를 포함해야 합니다.")
    private String password; // 비밀번호

    @NotBlank(message = "제목은 필수 항목입니다.")
    @Size(min = 4, max = 100, message = "제목은 4글자 이상 100글자 미만이어야 합니다.")
    private String title;

    @NotBlank(message = "내용은 필수 항목입니다.")
    @Size(min = 4, max = 2000, message = "내용은 4글자 이상 2000글자 미만이어야 합니다.")
    private String content;

    @Nullable
    private MultipartFile[] files = new MultipartFile[0]; // 파일

    /**
     * 삭제할 파일 Id들
     */
    List<Integer> deleteFileIdList = new ArrayList<>();
}
