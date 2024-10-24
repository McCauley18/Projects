using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

// NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "Service" in code, svc and config file together.
public class Service : IService    
{
    DataClassesDataContext db = new DataClassesDataContext();
    public int AddCategory(Category category)  
    {
        var cat = (from c in db.Categories
                   where c.Name.Equals(category.Name)
                   select c).FirstOrDefault();
        if(cat == null)
        {
            var newCategory = new Category
            {
                Name = category.Name,
                Description = category.Description
            };
            db.Categories.InsertOnSubmit(newCategory);
            try
            {
                db.SubmitChanges();
                return 0; //Added
            }
            catch (Exception e)
            {
                e.GetBaseException();
                return 2; //Error occured
            }
        }
        return 2; //Category exists
    }

    public int AddInvoice(Invoice invoice)
    {
        var newInvoice = new Invoice
        {
            DateDelivered = invoice.DateDelivered,
            InvoiceDate = invoice.InvoiceDate,
            ProductID = invoice.ProductID,
       //     Product.Equals(GetProduct(invoice.ProductID));
            quantitySold = invoice.quantitySold,
            TotalAmount = invoice.TotalAmount,
            UserID = invoice.UserID
        };
        db.Invoices.InsertOnSubmit(newInvoice);
        try
        {
            db.SubmitChanges();
            return 0;
        }
        catch (Exception e)
        {
            e.GetBaseException();
            return 2;
        }

    }

    public int AddOrder(Order order)
    {
        // var ord = (from o in db.Orders
        //          where )
        var newOrder = new Order
        {
            OrderDate = order.OrderDate,
            Status = order.Status,
            TotalAmount = order.TotalAmount,
            UserID = order.UserID
        };
        db.Orders.InsertOnSubmit(newOrder);
        try
        {
            db.SubmitChanges();
            return 0;
        }
        catch (Exception e)
        {
            e.GetBaseException();
            return 2;
        }
        
    }

    public int AddOrderItem(OrderItem item)
    {
        var newOrderItem = new OrderItem
        {
            OrderID = item.OrderID,
            ProductID = item.ProductID,
            Quantity = item.Quantity,
            Subtotal = item.Subtotal
        };
        db.OrderItems.InsertOnSubmit(newOrderItem);
        try
        {
            db.SubmitChanges();
            return 0;
        }
        catch (Exception e)
        {
            e.GetBaseException();
            return 2;
        }
    }

    public int AddPaymentMethod(PaymentMethod method)
    {
        var newMethod = new PaymentMethod
        {
            Address = method.Address,
            CardNumber = method.CardNumber,
            NameOnCard = method.NameOnCard,
            PostalCode = method.PostalCode,
            Town = method.Town,
            UserID = method.UserID
        };
        db.PaymentMethods.InsertOnSubmit(newMethod);
        try
        {
            db.SubmitChanges();
            return 0;
        }
        catch (Exception e)
        {
            e.GetBaseException();
            return 2;
        }
    }

    public int AddProduct(Product product)
    {
        var prod = (from p in db.Products
                    where p.Name.Equals(product.Name)
                    select p).SingleOrDefault();
        if(prod == null)
        {
            var newProduct = new Product
            {
                Name = product.Name,
                Category = product.Category,
                Description = product.Description,
                ImageURL = product.ImageURL,
                Price = product.Price,
                StockQuantity = product.StockQuantity
            };
            db.Products.InsertOnSubmit(newProduct);
            try
            {
                db.SubmitChanges();
                return 0;
            }
            catch (Exception e)
            {
                e.GetBaseException();
                return 2;
            }
        }
        return 1;
    }

    public int DeleteOrderItem(string OrderID, string ProductID)
    {
        var item = (from i in db.OrderItems
                    where i.OrderID.Equals(OrderID) && i.ProductID.Equals(ProductID)
                    select i).FirstOrDefault();
        if(item != null)
        {
            db.OrderItems.DeleteOnSubmit(item);
            try
            {
                db.SubmitChanges();
                return 0;
            }
            catch (Exception e)
            {
                e.GetBaseException();
                return 2;
            }
        }
        return 1;
    }

    public int editProduct(Product product)
    {
        var prod = (from p in db.Products
                    where p.Name.Equals(product.Name)
                    select p).SingleOrDefault();
        if(prod != null)
        {
            prod.Name = product.Name;
            prod.Price = product.Price;
            prod.ImageURL = product.ImageURL;
            prod.StockQuantity = product.StockQuantity;
            prod.Category = product.Category;
            prod.Description = product.Description;

            try
            {
                db.SubmitChanges();
                return 0;
            }
            catch (Exception e)
            {
                e.GetBaseException();
                return 2;
            }
        }
        return 1;
    }

    public List<Invoice> GetInvoice(int ID)
    {
        var invo = (from e in db.Invoices
                       where e.UserID.Equals(ID)
                       select e).DefaultIfEmpty();
        List<Invoice> invoices = new List<Invoice>();

        if(invo != null)
        {
            foreach(Invoice i in invo)
            {
                if(i != null)
                {
                    try
                    {
                        var newInvoice = new Invoice
                        {
                            InvoiceDate = i.InvoiceDate,
                            DateDelivered = i.DateDelivered,
                            ProductID = i.ProductID,
                            UserID = i.UserID,
                            quantitySold = i.quantitySold,
                            TotalAmount = i.TotalAmount
                        };
                        invoices.Add(newInvoice);
                    }
                    catch (Exception ex)
                    {
                        ex.GetBaseException();
                        return null;
                    }
                }
                else
                {
                    return null;
                }                                
            }
            return invoices;
        }
        return null;
    }

    public Product GetProduct(string name)
        {
        var prod = (from p in db.Products
                    where p.Name.Equals(name)
                    select p).SingleOrDefault();
        if(prod != null)
        {
            return prod;
        }
        return null;  
    }

    public Product GetProductByID(int ID)
    {
        var prod = (from p in db.Products
                    where p.Id.Equals(ID)
                    select p).SingleOrDefault();
        if (prod != null)
        {
            return prod;
        }
        return null;
    }

    public string GetProductName(int ID)
    {
        var prod = (from p in db.Products
                    where p.Id.Equals(ID)
                    select p).SingleOrDefault();
        if (prod != null)
        {
            return prod.Name;
        }
        return null;
    }

    public string getProductDescription(int intProductName)
    {
        var currentProduct = (from u in db.Products
                              where u.Id.Equals(intProductName)
                              select u).FirstOrDefault();

        return currentProduct.Description;
    }

    public User GetUser(int ID)
    {
        var use = (from u in db.Users
                   where u.Id.Equals(ID)
                   select u).SingleOrDefault();
        if(use != null)
        {
            return use;
        }
        return null;
    }

    public User GetUserName(string email)
    {
        var use = (from u in db.Users
                   where u.Email.Equals(email)
                   select u).SingleOrDefault();
        if (use != null)
        {
            return use;
        }
        return null;
    }

    public List<Product> productList(String BookCat)
    {
        List<Product> products = new List<Product>();

        var prod = (from p in db.Products where p.Category.Equals(BookCat)
                    select p).DefaultIfEmpty();
        if(prod != null)
        {
            foreach(Product i in prod)
            {
                var newProd = new Product
                {
                    Name = i.Name,
                    Price = i.Price,
                    Id = i.Id,
                    ImageURL = i.ImageURL,

                };
                products.Add(newProd);
            }
            return products;
        }
        else
        {   
            return null;
        }
         
    }

    public int RemoveCategory(string name)
    {
        var cat = (from c in db.Categories
                   where c.Name.Equals(name)
                   select c).SingleOrDefault();
        if(cat != null)
        {
            db.Categories.DeleteOnSubmit(cat);
            try
            {
                db.SubmitChanges();
                return 0;
            }
            catch (Exception e)
            {
                e.GetBaseException();
                return 2;
            }
        }
        return 1;
    }  

    public int RemoveProduct(string name)
    {
        var prod = (from p in db.Products
                    where p.Name.Equals(name)
                    select p).SingleOrDefault();

        if(prod != null)
        {
            db.Products.DeleteOnSubmit(prod);
            try
            {
                db.SubmitChanges();
                return 0;
            }
            catch (Exception e)
            {
                e.GetBaseException();
                return 2;
            }
        }
        return 1;
    }

    public bool UserLogin(string email, string password)
    {
        var user = (from u in db.Users
                    where u.Email.Equals(email) && u.Password.Equals(password)
                    select u).SingleOrDefault();
        if(user != null)
        {
            return true;
        }
        return false;
    }

    public int userRegister(User user)
    {
        var Reguser = (from u in db.Users
                       where u.Email.Equals(user.Email)
                       select u).SingleOrDefault();
        if(Reguser == null)
        {
            var newUser = new User
            {
                Email = user.Email,
                FirstName = user.FirstName,
                LastName = user.LastName,
                Password = user.Password,
                PhoneNumber = user.PhoneNumber,
                UserType = user.UserType
            };
            db.Users.InsertOnSubmit(newUser);
            try
            {
                db.SubmitChanges();
                return 0;
            }
            catch (Exception e)
            {
                e.GetBaseException();
                return 2;
                  
            }   
        }  
        return 1;
    }

    public decimal getProductPrice(int intProductName)
    {
        var currentProduct = (from u in db.Products
                              where u.Id.Equals(intProductName)
                              select u).FirstOrDefault();

        return (currentProduct.Price);
    }

    public int getProductQuantinty(int intProductName)
    {
        var currentProduct = (from u in db.Products
                              where u.Id.Equals(intProductName)
                              select u).FirstOrDefault();

        return currentProduct.StockQuantity;
    }

    public string getProductUrl(int intProductName)
    {
        var currentProduct = (from u in db.Products
                              where u.Id.Equals(intProductName)
                              select u).FirstOrDefault();

        return currentProduct.ImageURL;
    }

    public string getProductCategory(int intProductName)
    {
        var currentProduct = (from u in db.Products
                              where u.Id.Equals(intProductName)
                              select u).FirstOrDefault();

        return currentProduct.Category;
    }

    public bool UserRegisterBackup(string fname, string lname, string iemail, string ipassword, string iphonenumber, int iusertype)
    {
        var NewUser = new User
        { 
            FirstName = fname,
            LastName = lname,  
            Email = iemail,
            Password = ipassword,
            UserType = Convert.ToInt32(iusertype),
            PhoneNumber = iphonenumber,
              
        };
        db.Users.InsertOnSubmit(NewUser);          
        try  
        {
            db.SubmitChanges();
            return true;

        }   
        catch (Exception m)
        {
            m.GetBaseException();
            return false;
        }
    }

    public decimal getPrice(int ID)
    {
        var prod = (from p in db.Products
                    where p.Id.Equals(ID)
                    select p).SingleOrDefault();
        return prod.Price;
    }
}
