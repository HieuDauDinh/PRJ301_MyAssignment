/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function reloadWeeklyTable() {
        var lidValue = "${requestScope.lid}"; // Replace with your actual value

        // Construct the new URL
        var newUrl = "weeklyTable?lid=" + lidValue;

        // Set the new URL to reload the page
        window.location.href = newUrl;
    }
