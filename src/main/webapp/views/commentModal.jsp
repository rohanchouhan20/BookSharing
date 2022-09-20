
<div class="modal fade" id="exampleModal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Add Comment</h5>
				<button type="button" class="btn-close" data-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<form action="/comment/addcomment" action="post" autocomplete="off">
				<div class="modal-body">

					<input type="text" placeholder="Enter Comment" name="comment">
					<input type="text" hidden="true" id="commentUser" value=""
						name="commentUser"> <input type="text" hidden="true"
						id="postId" value="" name="postId">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger"
						data-dismiss="modal">Close</button>
					<button onClick="addComment()" type="submit" class="btn btn-success">Comment</button>
				</div>
			</form>
		</div>
	</div>
</div>