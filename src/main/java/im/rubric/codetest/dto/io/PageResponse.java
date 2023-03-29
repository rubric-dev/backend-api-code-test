package im.rubric.codetest.dto.io;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class PageResponse<T> extends ResponseBase {
    public Collection<T> data;
    public long currentIndex;
    public long totalElement;
    public long currentPage;
    public long totalPage;

    public PageResponse(Page<T> data, Pageable page) {
        setData(data, page);
    }

    public <U> PageResponse(Page<U> map) {
    }

    public void setData(Page<T> data, Pageable page) {
        setData(data.getContent(), data.getNumber(), data.getTotalElements(), page);
    }

    public void setData(List<T> data, long currentIndex, long totalElements, Pageable page) {
        this.data = data;
        this.currentIndex = currentIndex;
        this.currentPage = page.getPageNumber();
        this.totalElement = totalElements;
        this.totalPage = totalElements / page.getPageSize();
        if(totalElements % page.getPageSize() > 0) totalPage++;
    }
}
