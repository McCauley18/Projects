<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="HomePage.aspx.cs" Inherits="React_Website_FrontEnd_Web.HomePage" %>

<%--<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="UserPage.aspx.cs" Inherits="React_Website_FrontEnd_Web.UserPage" %>--%>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">


     <div class="hero-container">
                <img src="wait" />  
                <h1>Imagination Waits</h1>
                <p>What are you looking for</p>  
                <div class="btns">

                <asp:Button 
                 ID="GetStartedbtn"
                 runat="server"
                 Text="Get Started"
                 class="btn btn--outline btn-medium btn-block" 
                 OnClientClick="return redirectToSignUpPage();" 
                          
                 ></asp:Button>

                 <asp:Button 
                 ID="btnRecommendation"
                 runat="server"
                 Text="Recommendations"
                 class="btn btn--outline btn-medium btn-block" 
                 OnClientClick="return redirectToRecommendation();"                      
                 ></asp:Button>
                </div>


                <script type="text/javascript">
                    function redirectToSignUpPage() {
                        // Redirect to aps.aspx
                        window.location.href = 'SignUpPage.aspx';
                        return false; // Prevent postback
                    }
                </script>
         
                <script type="text/javascript">
                    function redirectToRecommendation() {
                        // Redirect to aps.aspx
                        window.location.href = 'Recommendation.aspx';
                        return false; // Prevent postback
                    }
                </script>

     </div>

    <div class="Appetite_Books"> 
                <div class="arrivals">
                    <br />
 
	<h2 style="text-align:center">Newest Arrivals</h2>

        <div class="arrivals_box">

            <div class="arrivals_card">
                <div class="arrivals_image">
                    <img src="https://github.com/EvaTheIntenstaller/GroupPG/blob/main/download%20(2).jpg?raw=true">
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
                    <img src="https://github.com/EvaTheIntenstaller/GroupPG/blob/main/images_folder/Adventure/Tarzen.jpg?raw=true">
                </div> 
                <%--//Changes here start--%>
                 
                <div class="arrivals_info">
                <h2>Book Name 1</h2>
                <p>Author Name 1</p>
                <p class="book_price">R250</p>
                <a href="#" class="arrivals_btn">Details</a>
               </div> 

                <%--changes end here--%>

            </div>


             <div class="arrivals_card">
                <div class="arrivals_image">
                    <img src="https://github.com/EvaTheIntenstaller/GroupPG/blob/main/images_folder/Adventure/The%20Jungle%20Book.jpg?raw=true">
                </div> 
                <%--//Changes here start--%>
                 
                <div class="arrivals_info">
                <h2>Book Name 1</h2>
                <p>Author Name 1</p>
                <p class="book_price">R200</p>
                <a href="#" class="arrivals_btn">Details</a>
               </div>
                  
                <%--changes end here--%>

            </div>



            <div class="arrivals_card">
                <div class="arrivals_image">
                    <img src="https://github.com/EvaTheIntenstaller/GroupPG/blob/main/download%20(5).jpg?raw=true">
                </div> 
                 <div class="arrivals_info">
                <h2>Book Name 1</h2>
                <p>Author Name 1</p>
                <p class="book_price">R200 </p>
                <a href="#" class="arrivals_btn">Details</a>
               </div>
            </div>

            
        </div>
             </div>
                
                


            </div>

    
</asp:Content>
  