<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="../includes/header.jsp" />
              <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Board Register</h1>
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Board Register</h6>
                        </div>
                        <div class="card-body">
                              <form method="post" >
							    <div class="form-group">
							      <label for="title">title</label>
							      <input type="text" class="form-control" id="title" placeholder="Enter title" name="title">
							    </div>
							    <div class="form-group">
							      <label for="comment">content</label>
							      <textarea rows="10" class="form-control"  id="comment" name="content"></textarea>
							    </div>
							    <div class="form-group">
							      <label for="writer">writer</label>
							      <input type="text" class="form-control" id="writer" placeholder="Enter writer" name="writer">
							    </div>
							    <div class="form-group">
								    <input type="file" name="files" id="files" class="d-none" multiple> 
								    <label class="btn btn-primary m-0" for="files" >라라라라</label>
								    <button type="button" class="btn btn-success" id="rororo">로로로로</button>
							    </div>
							    <div class="upload-wrap">
							    	파일없음
							    </div>
							    <button type="submit" class="btn btn-primary">Submit</button>
							    <input type="hidden" name="pageNum" value="1">
							    <input type="hidden" name="amount" value="${cri.amount}">
							  </form>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

<script>
	$("#files").change(function() {
		//console.log(this.files);
		$(".upload-wrap").html("");
		if(!this.files.length) {
			$(".upload-wrap").text("파일없음");
			return;
		}
		for(let file of this.files) {
			if(file.type.startsWith("image")) { // image
				let img = $("<img>").attr("src", URL.createObjectURL(file)).css("height", 60);
				$(".upload-wrap").append(img);
				URL.revokeObjectURL(file);
			}
		}
	})
	
	$("#rororo").click(function() {
		console.log($("#files").get(0).files.length);
	})
</script>
<jsp:include page="../includes/footer.jsp" />