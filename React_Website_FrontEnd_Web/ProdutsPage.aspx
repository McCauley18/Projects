<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="ProdutsPage.aspx.cs" Inherits="React_Website_FrontEnd_Web.ProdutsPage" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    
    <div>

        <div class="Appetite_Books"> 
                <div class="arrivals">
                    <br />
 
	<h2 style="text-align:center">Best Selling Books</h2>

        <div class="arrivals_box">

            <div class="arrivals_card">
                <div class="arrivals_image">
                    <img src="https://github.com/EvaTheIntenstaller/GroupPG/blob/main/download%20(1).jpg?raw=true">
                </div> 
                <%--//Changes here start--%>
                 
                <div class="arrivals_info">
                <h2>Book Name 1</h2>
                <p>Author Name 1</p>
                <p class="book_price">R300</p>
                <a href="#" class="arrivals_btn">Details</a>
               </div>
 
            </div> 

             <div class="arrivals_card">
                <div class="arrivals_image">
                    <img src="https://github.com/EvaTheIntenstaller/GroupPG/blob/main/download%20(6).jpg?raw=true">
                </div> 
                <%--//Changes here start--%>
                 
                <div class="arrivals_info">
                <h2>Book Name 1</h2>
                <p>Author Name 1</p>
                <p class="book_price">$19.99</p>
                <a href="#" class="arrivals_btn">Details</a>
               </div> 

                <%--changes end here--%>

            </div>


             <div class="arrivals_card">
                <div class="arrivals_image">
                    <img src="https://github.com/EvaTheIntenstaller/GroupPG/blob/main/download%20(3).jpg?raw=true">
                </div> 
                <%--//Changes here start--%>
                 
                <div class="arrivals_info">
                <h2>Book Name 1</h2>
                <p>Author Name 1</p>
                <p class="book_price">$19.99</p>
                <a href="#" class="arrivals_btn">Details</a>
               </div>

                <%--changes end here--%>

            </div>



            <div class="arrivals_card">
                <div class="arrivals_image">
                    <img src="https://github.com/EvaTheIntenstaller/GroupPG/blob/main/download%20(4).jpg?raw=true">
                </div> 
                 <div class="arrivals_info">
                <h2>Book Name 1</h2>  
                <p>Author Name 1</p>
                <p class="book_price">$19.99 </p>
                <a href="#" class="arrivals_btn">Details</a>
               </div>
            </div>

             
        </div>
	




             </div>
                
                


            </div>
    
</div>
    <br /> <br />



</asp:Content>
