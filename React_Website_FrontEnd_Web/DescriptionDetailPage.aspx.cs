using React_Website_FrontEnd_Web.ServiceReference1;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace React_Website_FrontEnd_Web
{
    public partial class DescriptionDetailPage : System.Web.UI.Page
    {
        ServiceClient sc = new ServiceClient();


        protected void Page_Load(object sender, EventArgs e)
        {
            //String DetailFiction = "";
            //dynamic DetailF = sc.GetProduct("The Hunger Games");
            //int IntIDz = 0;


            //foreach (Product d in DetailF)
            //{
            if (!IsPostBack)
            {
                // Retrieve the product ID from the URL parameters
                if (Request.QueryString["productId"] != null)
                {  
                    int productId = Convert.ToInt32(Request.QueryString["productId"]);
                    string productName = sc.GetProductName(productId);
                    string description = sc.getProductDescription(productId);
                    decimal price = sc.getProductPrice(productId);
                    string category = sc.getProductCategory(productId);
                    string imageUrl = sc.getProductUrl(productId);

                    // Create the HTML for displaying product details
                    String DetailFiction = "";

                    DetailFiction += "<div style='background-color: white;";
                    DetailFiction += "width: 50%;";
                    DetailFiction += "float: left;'>";
                    DetailFiction += "<img width='900' height='800' src='" + imageUrl + "' />";
                    DetailFiction += "</div>";
                    DetailFiction += "<div style='background-color: white;";
                    DetailFiction += "width: 50%;";
                    DetailFiction += "float: right;'>";
                    DetailFiction += "<p style='text-align: right;'>";
                    DetailFiction += "<h2 style='color: black;'>" + productName + "</h2>";
                    DetailFiction += "<h4 style='color: black;'>" + category + "</h4>";
                    DetailFiction += "<h4 style='color: black;'>Price: R" + price + "</h4>";
                    DetailFiction += "</ul></h4>";
                    DetailFiction += "<h4 style='color: black;'><b>Synopsis: </b><p>" + description + "</p></h4>";
                    DetailFiction += "</p>";
                    DetailFiction += "<a href='Cart.aspx?productId=" + productId + "' class='arrivals_btn' style='border: 2px solid black; padding: 10px 20px; background - color: white; color: black;'>Add to Cart</a>";
                    DetailFiction += "</div>";
                     

                    DetailPage.InnerHtml = DetailFiction;
                    // Display the product details in the HTML
                    // You can set the HTML to a label or another control to render it on the page
                    // For example, if you have a Label control named "lblProductDetails":
                    // lblProductDetails.Text = DetailFiction;
                }
                else
                {
                    // Handle the case where productId is not provided in the URL parameters
                    // You can display an error message or redirect the user to a different page.
                }
               
            }
           
        }
    }

}