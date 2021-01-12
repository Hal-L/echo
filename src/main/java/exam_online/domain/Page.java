package KnowledgePoints.myInterface.interFalse.exam_online.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 分页相关实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> implements Serializable {

    private Integer pageNum; //当前页码

    private Integer pageSize; //每页显示记录数

    private Integer pages; //总页数

    private Long total; //总记录数

    private List<T> result; //当前页的列表集合
}