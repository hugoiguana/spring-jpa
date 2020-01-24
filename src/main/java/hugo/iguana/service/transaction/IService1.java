package hugo.iguana.service.transaction;

public interface IService1 {

    void insertManyWithDefaultTransactionButDontOccurRollbackWhenTheExceptionIsHandle();

    void insertManyWithDefaultTransactionButWillOccurRollbackWhenTheExceptionIsNotHandle();

    void insertManyWithSeparatedTransactionButWillOccurRollbackOfOnlyOneInsert();
}
