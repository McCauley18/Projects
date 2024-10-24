<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="wishlist.aspx.cs" Inherits="React_Website_FrontEnd_Web.WebForm2" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Wishlist</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        .wishlist-container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f9f9f9;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .wishlist-item {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 10px;
        }

        .wishlist-item-remove {
            cursor: pointer;
            color: red;
        }
    </style>
</head>

<body>
    <div class="wishlist-container">
        <h2>My Wishlist</h2>
        <div id="wishlist-items">
            <!-- Wishlist items will be displayed here -->
        </div>
        <input type="text" id="item" placeholder="Enter item">
        <button onclick="addItem()">Add to Wishlist</button>
    </div>

    <script>
        function addItem() {
            var item = document.getElementById("item").value;
            if (item.trim() === "") {
                alert("Please enter an item.");
                return;
            }

            var wishlistItems = document.getElementById("wishlist-items");
            var newItem = document.createElement("div");
            newItem.className = "wishlist-item";
            newItem.innerHTML = `
                <span>${item}</span>
                <span class="wishlist-item-remove" onclick="removeItem(this)">Remove</span>
            `;
            wishlistItems.appendChild(newItem);

            // Clear input field after adding item to the wishlist
            document.getElementById("item").value = "";
        }

        function removeItem(itemElement) {
            // Remove the parent element of the clicked remove button
            itemElement.parentElement.remove();
        }
    </script>
</body>

</html>

</asp:Content>
