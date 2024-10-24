using React_Website_FrontEnd_Web.ServiceReference1;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Diagnostics;


namespace React_Website_FrontEnd_Web
{
    public partial class UserPage : System.Web.UI.Page
    {
        ServiceClient sc = new ServiceClient();

        protected void Page_Load(object sender, EventArgs e)
        {
            dynamic NewBooks = sc.productList("Fiction");
            String NewDisplay = " ";

            dynamic Bestbooks = sc.productList("Fiction");
            String BestDisplay = " ";

            dynamic AdventureBooks = sc.productList("Adventure");
            String AdventureDisplay = " ";

            dynamic ROmanceBooks = sc.productList("Romance");
            String RomanceDisplay = " ";

            int counter = 0;

              
            // This is the product that will be choosen
            int id = 0, stockQuantity = 0;
            string productName = " ", productDescription = " ", productCategory = " ", productUrl = "";
            float price = 0;

            foreach (Product p in NewBooks)
            {

                NewDisplay += "<div class='arrivals_card'>";
                NewDisplay += "<div class='arrivals_image'>";
                NewDisplay += "<a href='DescriptionDetailPage.aspx?productId="+p.Id+"'><img src='" + p.ImageURL + "'></a>";
                NewDisplay += "</div>";
                NewDisplay += "<div class='arrivals_info'>";
                NewDisplay += "<h2>" + p.Name + "</h2>";
                NewDisplay += "<p>"  +p.Category+"</p>";
                NewDisplay += "<p class='book_price'>" + p.Price + "</p>";
                NewDisplay += "<a href='DescriptionDetailPage.aspx?productId=" + p.Id + "' class='arrivals_btn'>Details</a>";
                NewDisplay += "<a href='Cart.aspx?productId=" + p.Id + "' class='arrivals_btn'>Add to Cart</a>";
                NewDisplay += "</div>";
                NewDisplay += "</div>";  

                // Get the product id here
                id = p.Id;
                counter++;

            }
            newbooks.InnerHtml = NewDisplay;

            counter = 0;
            foreach (Product p in Bestbooks)
            {


                AdventureDisplay += "<div class='arrivals_card'>";
                AdventureDisplay += "<div class='arrivals_image'>";
                AdventureDisplay += "<a href='DescriptionDetailPage.aspx?productId=" + p.Id + "'><img src='" + p.ImageURL + "'></a>";
                AdventureDisplay += "</div>";
                AdventureDisplay += "<div class='arrivals_info'>";
                AdventureDisplay += "<h2>" + p.Name + "</h2>";
                AdventureDisplay += "<p>" + p.Category + "</p>";
                AdventureDisplay += "<p class='book_price'>" + p.Price + "</p>";
                AdventureDisplay += "<a href='DescriptionDetailPage.aspx?productId=" + p.Id + "' class='arrivals_btn'>Details</a>";
                AdventureDisplay += "<a href='Cart.aspx?productId=" + p.Id + "' class='arrivals_btn'>Add to Cart</a>";
                AdventureDisplay += "</div>";
                AdventureDisplay += "</div>";

                // Get the product id here
                id = p.Id;
                counter++;

            }
            bestselling.InnerHtml = BestDisplay;

            counter = 0;
            foreach (Product p in AdventureBooks)
            {

                BestDisplay += "<div class='arrivals_card'>";
                BestDisplay += "<div class='arrivals_image'>";
                BestDisplay += "<a href='DescriptionDetailPage.aspx?productId=" + p.Id + "'><img src='" + p.ImageURL + "'></a>";
                BestDisplay += "</div>";
                BestDisplay += "<div class='arrivals_info'>";
                BestDisplay += "<h2>" + p.Name + "</h2>";
                BestDisplay += "<p>" + p.Category + "</p>";
                BestDisplay += "<p class='book_price'>" + p.Price + "</p>";
                BestDisplay += "<a href='DescriptionDetailPage.aspx?productId=" + p.Id + "' class='arrivals_btn'>Details</a>";
                BestDisplay += "<a href='Cart.aspx?productId=" + p.Id + "' class='arrivals_btn'>Add to Cart</a>";
                BestDisplay += "</div>";
                BestDisplay += "</div>";
                // Get the product id here
                id = p.Id;
                counter++;

            }
            Advent.InnerHtml = AdventureDisplay;

            counter = 0;
            foreach (Product p in ROmanceBooks)
            {


                RomanceDisplay += "<div class='arrivals_card'>";
                RomanceDisplay += "<div class='arrivals_image'>";
                RomanceDisplay += "<a href='DescriptionDetailPage.aspx?productId=" + p.Id + "'><img src='" + p.ImageURL + "'></a>";
                RomanceDisplay += "</div>";
                RomanceDisplay += "<div class='arrivals_info'>";
                RomanceDisplay += "<h2>" + p.Name + "</h2>";
                RomanceDisplay += "<p>" + p.Category + "</p>";
                RomanceDisplay += "<p class='book_price'>" + p.Price + "</p>";
                RomanceDisplay += "<a href='DescriptionDetailPage.aspx?productId=" + p.Id + "' class='arrivals_btn'>Details</a>";
                RomanceDisplay += "<a href='Cart.aspx?productId=" + p.Id + "' class='arrivals_btn'>Add to Cart</a>";
                RomanceDisplay += "</div>";
                RomanceDisplay += "</div>";


                // Get the product id here
                id = p.Id;
                counter++;

            }
            Salez.InnerHtml = RomanceDisplay;

            //counter = 0;
            //foreach (Product p in HoldBooks)
            //{

            //    DisplayBooks += "<div class='arrivals_card'>";
            //    DisplayBooks += "<div class='arrivals_image'>";
            //    DisplayBooks += "<img src='" + p.ImageURL + "'>";
            //    DisplayBooks += "</div>";
            //    DisplayBooks += "<div class='arrivals_info'>";
            //    DisplayBooks += "<h2>" + p.Name + "</h2>";
            //    DisplayBooks += "<p>Author Name 1</p>";
            //    DisplayBooks += "<p class='book_price'>" + p.Price + "</p>";
            //    DisplayBooks += "<a href='#' class='arrivals_btn'>Details</a>";
            //    DisplayBooks += "</div>";
            //    DisplayBooks += "</div>";
            //    counter++;

            //}
            //newbooks.InnerHtml = DisplayBooks;

            /* if (Request.QueryString["productId"] != null)
             {
                 int productId = Convert.ToInt32(Request.QueryString["productId"]);
                 Product currentProduct = sc.getProduct(productId);

                 Debug.WriteLine(currentProduct);
                 // Add a function to retreive product data using a database function


                 if (Request.Cookies["aa"] == null)
                 {
                     Response.Cookies["aa"].Value = currentProduct.Name+ "," + currentProduct.Description + "," + currentProduct.ToString() + "," + productCategory + "," + stockQuantity.ToString() + "," + productUrl;
                     Request.Cookies["aa"].Expires = DateTime.Now.AddDays(1);
                 }
                 else
                 {
                     Response.Cookies["aa"].Value = Response.Cookies["aa"].Value + "|" + productName + "," + productDescription + "," + price.ToString() + "," + productCategory + "," + stockQuantity.ToString() + "," + productUrl;


                 }

             }
             else
             {
                 Debug.WriteLine("It was null");
             }


         }*/
        }
    }
}