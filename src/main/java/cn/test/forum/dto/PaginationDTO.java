package cn.test.forum.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;//当前页
    private Integer totalPage;
    private List<Integer> pages = new ArrayList<>();




    public void setPagination(Integer totalCount, Integer page, Integer size) {
        if(totalCount % size ==0){
            this.totalPage = totalCount / size;
        }else{
            this.totalPage = totalCount / size +1;
        }

        if(page < 1){
            page = 1;
        }
        if(page > totalPage){
            page = totalPage;
        }
        this.page = page;

        pages.add(page);
        for(int i=1; i<=3; i++){
            if(page-i > 0){
                pages.add(0, page - i);
            }
            if(page+i <= totalPage){
                pages.add(page+i);
            }
        }



        if(page == 1){
            showPrevious = false;
        }else {
            showPrevious = true;
        }

        if(page == totalPage){
            showNext = false;
        }else{
            showNext = true;
        }

        if(pages.contains(1)){
            showFirstPage = false;
        }else{
            showFirstPage = true;
        }
        if(pages.contains(totalPage)){
            showEndPage = false;
        }else{
            showEndPage = true;
        }


    }
}
