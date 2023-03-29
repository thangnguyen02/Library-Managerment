<%-- 
    Document   : homePage
    Created on : Oct 29, 2022, 6:53:47 AM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <% 
            List<Message> ls3 = (List<Message>)request.getAttribute("listms");
            HashMap<Book,Integer> t = (HashMap<Book,Integer>)request.getAttribute("Top3");
        %>
        <h3 style="color: red">Top 3: </h3><!-- comment -->
        <table class="table_css">
            <tr class="fir">
                <td>ID</td>
                <td>Name</td>
                <td>Amount</td>
            </tr>
        <% for (Book b: t.keySet()) {%>
            <tr>
                <td><%= b.getId()%></td>
                <td><%= b.getName()%></td>
                <td><%= t.get(b)%></td>
            </tr>
        <% }%>
        </table>
            <h3 style="color: red">Thông báo</h3>
                 <% if (request.getAttribute("listms") == null || ls3.isEmpty()) {%>
                <p>Bạn không có thông báo nào cả !!</p>
                <% } else {%>
                <table class="table_css">        
                    <% for (Message b : ls3) {%> 
                    <tr style="padding: 10px 0px;">
                    <td><%= b.getMess() %> </td>
                    <td><%= b.getDate() %> </td>
                    </tr>
                    <% } %>
                </table>
                <% } %>
                <div class="thongbao">
                    <h3  style="color: red">Gia hạn tài liệu mượn thư viện</h3>
                    <h4>1. Chính sách:</h4>
                    <p> - Áp dụng đối với các nhóm bạn đọc đang  mượn tài liệu của Thư viện về nhà.<br>
                        - Tài liệu chỉ có thể được Gia hạn khi đã đến hạn trả hoặc trước hạn trả 3 ngày.<br>
                        - Số lượt gia hạn tối đa là 4 lần, hết 4 lần này bạn đọc cần mang tài liệu qua thư viện để kiểm tra lại và mượn mới nếu sách không có ai đặt chỗ và không bị khóa thẻ. Khi tài liệu đã có người Đặt mượn thì sẽ không Gia hạn được.<br></p>
                    <h4>2. Hướng dẫn thực hiện:</h4>
                    <p> Bạn đọc có thể gia hạn tài liệu thông qua thủ thư theo cách sau:<br><br>
                        Trực tiếp tại quầy thủ thư : Bạn đọc cung cấp mã số sinh viên và tên sách cần gia hạn. Thủ thư sẽ gia hạn theo thời hạn đã quy định và thông báo hạn trả mới với bạn đọc khi gia hạn thành công.<br>
                        Thư viện có hệ thống email nhắc nhở bạn đọc trả sách. Theo đó, số email nhắc nhở tối đa mà bạn đọc nhận được khi mượn một tài liệu của thư viện là 5 lần:<br><br>
                        Library 's Overdue notice : Email báo hạn trả trước 1 ngày.<br>
                        Library 's Overdue notice 1(st): Email báo quá hạn 1 ngày.<br>
                        Library 's Overdue notice 2(nd): Email báo quá hạn 7 ngày.<br>
                        Library 's Overdue notice 3(rd): Email báo quá hạn 14 ngày.<br>
                        Library 's Overdue notice 4(th): Email báo quá hạn 21 ngày.<br><br>
                        Kể từ sau email thứ 5 này, nếu bạn đọc vẫn tiếp tục không có hoạt động gia hạn, sách quá hạn trên 30 ngày thư viện sách được coi như mất và thủ thư thanh lý sách theo quy định.<br>
                    
                    </p>
                    <h4>3. Quy chế phạt:</h4>
                    <p>Sinh viên được mượn sách tối đa 2 tháng (60 ngày) kể từ ngày xác nhận mượn.<br> Số ngày vượt quá sẽ quy ra tiền với mức phạt 5.000VND/1 ngày/1 quyển </p>
                </div>
    </body>
</html>
