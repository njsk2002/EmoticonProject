<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="../includes/admin-header.jsp" %>

<main id="main" class="main">
   <div class="mt-3 px-5 py-4 pagetitle">
     <h4>상품삭제</h4>
     <nav>
      <ol class="breadcrumb">
      <li class="breadcrumb-item"> <a href="#"> 판매관리 </a></li>
      <li class="breadcrumb-item breadcrumb-item active">상품 삭제</li>     
      </ol>    
     </nav>
   </div><!--  End Page Title -->
   
   <section class="section px-5">
    <div class="row">
      <div class="col-lg-12">
      
    <div class="card">
       <div class="py-3 card-body">
        <h5 class="py-4 px-4 card-title">Enter password to delete</h5>
        
        <!-- No Labels Form  -->
        <Form class="px-4 row g-3" role="form" action="/admin/remove" method="post">
          <div class="col-md-12">
             <input type="text" class="form-control" placeholder="삭제하시려면 관리자 비밀번호를 입력해주세요." name="m_pw">
              <c:if test="${msg == false }">
              <p style="color: red">비밀번호 불일치</p>
              </c:if>
              <input type="hidden" name="before-image" value="${product.p_image }"/>
              <input type="hidden" name="p_name" value="${product.p_name }"/>
              <input type="hidden" name="p_no" value="${product.p_no }"/>            
          </div>
          
          <div class="text-center py-4">         
           <!--  <button type="submit" class="px-4 py-2 btn btn-success">Edit</button> -->
          <button type="submit" class="px-5 py-2 btn btn-secondary">Delete</button>
          </div>       
        </Form> <!-- End no Lable Form -->
       
    </div>    
    </div>  
    </div>   
    </div>   
   </section>

</main> <!--  end #Main -->
<head>
<meta charset="UTF-8">
<%@include file="../includes/admin-footer.jsp" %>
</body>
</html>