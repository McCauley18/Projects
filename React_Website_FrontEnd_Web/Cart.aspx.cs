using React_Website_FrontEnd_Web.ServiceReference1;
using System;
using System.Collections.Generic;
using System.Web.UI;
using System.Linq;

namespace React_Website_FrontEnd_Web
{
    public partial class WebForm1 : Page
    {
        ServiceClient sc = new ServiceClient();

        public class CartItem
        {
            public int ProductId { get; set; }
            public string ProductName { get; set; }
            public int Quantity { get; set; }
            public decimal PricePerUnit { get; set; }
            public decimal Sum { get; set; }
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            // Always load the cart from session
            List<CartItem> cart = (List<CartItem>)Session["Cart"];
            if (cart == null)
            {
                cart = new List<CartItem>();
            }

            if (!IsPostBack)
            {
                if (Request.QueryString["productId"] != null)
                {
                    int productId = Convert.ToInt32(Request.QueryString["productId"]);
                    Session["CartProdID"] = productId;
                    string productName = sc.GetProductName(productId);
                    decimal price = sc.getProductPrice(productId);

                    var cartItem = new CartItem
                    {
                        ProductId = productId,
                        ProductName = productName,
                        Quantity = 1,
                        PricePerUnit = price
                    };

                    // Add the new item to the cart
                    cart.Add(cartItem);

                    // Save the updated cart back to session state
                    Session["CartQuantity"] = cartItem.Quantity;
                    Session["CartTotal"] = cartItem.Quantity * sc.getPrice(productId);
                }
                // No need to bind the GridView here, it will be bound after the if-else block

            }

            // Bind the cart to the GridView
            GridViewCart.DataSource = cart;
            GridViewCart.DataBind();

            decimal totalPrice = cart.Sum(item => item.PricePerUnit * item.Quantity);
            Session["CartPrice"] = totalPrice;
            GridViewCart.FooterRow.Cells[2].Text = "Total: " + totalPrice.ToString("C"); // Assuming the total price column is at index 2 in the GridView

            // Display message if cart is empty
            CartEmptyLabel.Visible = cart.Count == 0;
            // Display message if cart is empty
            if (cart.Count == 0)
            {
                CartEmptyLabel.Visible = true;
            }
            else
            {
                CartEmptyLabel.Visible = false;
            }
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            Response.Redirect("Checkout.aspx");
        }
    }




}