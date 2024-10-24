using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

// NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IService" in both code and config file together.
[ServiceContract]
public interface IService
{  
    [OperationContract]
    int AddProduct(Product product); 
    [OperationContract]
    string GetProductName(int ID);

    [OperationContract]
    int editProduct(Product product);

    [OperationContract]
    List<Product> productList(String BookCat);

    [OperationContract]
    int RemoveProduct(string name);   

    [OperationContract]
    int RemoveCategory(string name);

    [OperationContract]
    int AddOrder(Order order);    

    [OperationContract]
    int AddPaymentMethod(PaymentMethod method);

    [OperationContract]
    int AddOrderItem(OrderItem item);

    [OperationContract]
    Product GetProduct(string name);
        [OperationContract]
    int DeleteOrderItem(string OrderID, string ProductID); 

    [OperationContract]  
    bool UserLogin(string email, string password);

    [OperationContract]
    int userRegister(User user);

    [OperationContract]
    User GetUser(int ID);

    [OperationContract]
    User GetUserName(string email);

    [OperationContract]  
    List<Invoice> GetInvoice(int ID);

    [OperationContract]
    int AddInvoice(Invoice invoice);

    [OperationContract]
    decimal getProductPrice(int intProductName);

    [OperationContract]
    string getProductUrl(int intProductName);

    [OperationContract]
    int getProductQuantinty(int intProductName);

    [OperationContract]
    string getProductDescription(int intProductName);

    [OperationContract]
    string getProductCategory(int intProductName);

    [OperationContract]
    decimal getPrice(int ID);

    //Register 2 for testing purpose in substitute of userRegsiter by XS
    [OperationContract]  
    bool UserRegisterBackup(string fname, string lname, string iemail, string ipassword,  string iphonenumber, int iusertype);
}
