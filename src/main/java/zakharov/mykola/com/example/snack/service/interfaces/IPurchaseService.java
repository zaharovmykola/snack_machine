package zakharov.mykola.com.example.snack.service.interfaces;

import zakharov.mykola.com.example.snack.model.CategoryModel;
import zakharov.mykola.com.example.snack.model.ResponseModel;

import java.time.LocalDate;

public interface IPurchaseService {
    ResponseModel purchase(String categoryName, LocalDate date);
    ResponseModel reportByDay(LocalDate date);
    ResponseModel reportByMonth(String yearMonth);
}
