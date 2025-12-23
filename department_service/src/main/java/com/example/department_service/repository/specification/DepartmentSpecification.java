package com.example.department_service.repository.specification;

import com.example.department_service.entity.Department;
import com.example.department_service.form.DepartmentFilterForm;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DepartmentSpecification {
    public static Specification<Department> build(String search, DepartmentFilterForm filterForm) {
        return (root, query, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            // ===== SEARCH theo name =====
            if (search != null && !search.trim().isEmpty()) {
                predicates.add(
                        cb.like(
                                cb.lower(root.get("name")),
                                "%" + search.trim().toLowerCase() + "%"
                        )
                );
            }

            if (filterForm != null) {

                // ===== FILTER theo type =====
                if (filterForm.getType() != null) {
                    predicates.add(
                            cb.equal(root.get("type"), filterForm.getType())
                    );
                }

                // ===== FILTER createdDate (đúng ngày) =====
                if (filterForm.getCreatedDate() != null) {
                    Date start = startOfDay(filterForm.getCreatedDate());
                    Date end = endOfDay(filterForm.getCreatedDate());

                    predicates.add(
                            cb.between(root.get("createdDate"), start, end)
                    );
                }

                // ===== FILTER minCreatedDate =====
                if (filterForm.getMinCreatedDate() != null) {
                    predicates.add(
                            cb.greaterThanOrEqualTo(
                                    root.get("createdDate"),
                                    startOfDay(filterForm.getMinCreatedDate())
                            )
                    );
                }

                // ===== FILTER maxCreatedDate =====
                if (filterForm.getMaxCreatedDate() != null) {
                    predicates.add(
                            cb.lessThanOrEqualTo(
                                    root.get("createdDate"),
                                    endOfDay(filterForm.getMaxCreatedDate())
                            )
                    );
                }

                // ===== FILTER minYear =====
                if (filterForm.getMinYear() != null) {
                    predicates.add(
                            cb.greaterThanOrEqualTo(
                                    root.get("year"),
                                    filterForm.getMinYear()
                            )
                    );
                }
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

    // ===== HÀM HỖ TRỢ =====
    private static Date startOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    private static Date endOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }
}
