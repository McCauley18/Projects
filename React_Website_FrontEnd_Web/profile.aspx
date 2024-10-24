<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="profile.aspx.cs" Inherits="React_Website_FrontEnd_Web.WebForm3" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
    <style>

        .profile-container {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 40px;
            text-align: center;
        }

        .profile-picture {
            width: 150px;
            height: 150px;
            border-radius: 50%;
            object-fit: cover; /* Ensure the entire image is visible within the circular frame */
            margin-bottom: 20px;
        }

        .profile-name {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 10px;
        }

        .profile-email {
            color: #888;
            margin-bottom: 20px;
        }

        .profile-bio {
            font-style: italic;
            color: #555;
        }
    </style>
</head>

<body>
    <div class="profile-container">
        <img src="https://raw.githubusercontent.com/EvaTheIntenstaller/GroupPG/91b71d57a50c7e62ab9c6c7b352e02bcc27223fe/user-solid.svg" alt="Profile Picture" class="profile-picture">
        <div class="profile-name">Mbuyelo Hlebela</div>
        <div class="profile-email">
            <p>

               <span><b>Email:</b></span> MbuyeloHlebela@example.com <br />
                
            </p> 
        </div>
        
    </div>
</body>

</html>

</asp:Content>
