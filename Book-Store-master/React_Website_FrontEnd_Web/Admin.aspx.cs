using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using React_Website_FrontEnd_Web.ServiceReference1;


namespace React_Website_FrontEnd_Web
{
    public partial class WebForm6 : System.Web.UI.Page
    {
        ServiceClient sc = new ServiceClient();
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnDelete_Click(object sender, EventArgs e)
        {
            string name = TextBox1.Text;
            int deleted = sc.RemoveProduct(name);
            if (deleted == 0)
            {
                Label1.Text = "Book Deleted";
            }
            else
            {
                Label1.Text = "Book Name not found";
            }
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            Product product = new Product
            {
                Name = TextBox2.Text,
                Description = TextBox3.Text,
                Price = Convert.ToDecimal(TextBox4.Text),
                Category = TextBox5.Text,
                StockQuantity = Convert.ToInt32(TextBox6.Text),
                ImageURL = TextBox7.Text,
            };
            int addProd = sc.AddProduct(product);
            if (addProd == 0)
            {
                Label2.Text = "Book Added";
            }
            else if (addProd == 1)
            {
                Label2.Text = "Book already exists";
            }
            else
            {
                Label3.Text = "Invalid input in price or stock quantity";
            }
        }

        protected void Button2_Click(object sender, EventArgs e)
        {
            Product product = new Product
            {
                ImageURL = TextBox13.Text,
                Category = TextBox11.Text,
                Description = TextBox9.Text,
                Name = TextBox14.Text,
                Price = Convert.ToDecimal(TextBox10.Text),
                StockQuantity = Convert.ToInt32(TextBox12.Text)
            };
            int update = sc.editProduct(product);
            if (update.Equals(0))
            {
                Label3.Text = "Book Updated";
            }
            else
            {
                Label3.Text = "At least one input is invalid";
            }
        }

        protected void Button3_Click(object sender, EventArgs e)
        {
            string name = TextBox8.Text;
            var product = sc.GetProduct(name);
            if (product != null)
            {
                TextBox14.Text = product.Name;
                TextBox9.Text = product.Description;
                TextBox10.Text = Convert.ToString(product.Price);
                TextBox11.Text = product.Category;
                TextBox12.Text = Convert.ToString(product.StockQuantity);
                TextBox13.Text = product.ImageURL;

                btnUpdate.Visible = true;
            }
            else
            {
                Label3.Text = "Book name not found";
            }
        }
    }
}