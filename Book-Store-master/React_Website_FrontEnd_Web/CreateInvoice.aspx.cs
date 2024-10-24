using React_Website_FrontEnd_Web.ServiceReference1;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace React_Website_FrontEnd_Web
{  
    public partial class CreateInvoice : System.Web.UI.Page
    {
       ServiceClient sc = new ServiceClient();
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void LinkButton1_Click(object sender, EventArgs e)
        {
            cldDate.Visible = true;            
        }

        protected void btnProceed_Click(object sender, EventArgs e)
        {
            int userID = Convert.ToInt32(Session["UserID"]);
            int prodID = Convert.ToInt32(Session["ProdID"]);
            string sDate = Convert.ToString(System.DateTime.Today).Substring(0, 10);
            DateTime date = Convert.ToDateTime(sDate);
            int quantity = Convert.ToInt32(TextBox3.Text);
            DateTime toDeliver = cldDate.SelectedDate;
            Decimal total = Convert.ToDecimal(Session["TotalPrice"]);

            Invoice invoice = new Invoice
            {
                DateDelivered = toDeliver,                
                InvoiceDate = date,
                ProductID = prodID,
                quantitySold = quantity,
                UserID = userID,
                TotalAmount = total
            };

            int success = sc.AddInvoice(invoice);
            if (success.Equals(0))
            {
                Response.Redirect("ProdutsPage.aspx");
            }
        }

        protected void btnDone_Click(object sender, EventArgs e)
        {
            int ID = Convert.ToInt32(Session["UserID"]);

            string name = DropDownList1.Text;
            var product = sc.GetProduct(name);
            int prodId = product.Id;
            Session["ProdID"] = prodId;
            string invoiceDate = Convert.ToString(System.DateTime.Today).Substring(0, 10);

            int quantity = Convert.ToInt32(TextBox3.Text);
            DateTime date = cldDate.SelectedDate;

            lblTotal.Text = "R " + Math.Round((product.Price * quantity), 2);
            Session["TotalPrice"] = product.Price * quantity;
                       
            lblTotal.Visible = true;
            btnProceed.Visible = true;
        }

    }
}