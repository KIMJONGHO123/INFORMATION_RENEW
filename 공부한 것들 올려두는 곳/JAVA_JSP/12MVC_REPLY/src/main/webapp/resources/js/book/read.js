/**
 * 
 */
//const path = '${pageContext.request.contextPath}';

console.log("read.js");

console.log(path);
const replyAddBtn = document.querySelector(".reply-add-btn");

replyAddBtn.addEventListener('click',()=>{
	
	const contents = document.querySelector('.reply-header textarea').value;
	axios.get(`${path}/book/reply/create?bookCode=${bookCode}&contents=${contents}`)
		 .then((resp)=>{
			console.log(resp)
			document.querySelector('.reply-header textarea').value="";
			receiveReplyData()
		 })
		 .catch((error)=>{console.log(error)})
	
	//createReplyItem();
})

function receiveReplyData(){
		axios.get(`${path}/book/reply/list?bookCode=${bookCode}`)
			 .then((resp)=>{
				
				// 기존 items의 노드 제거
				const itemEl = document.querySelector('.reply-body .items');
				while(itemEl.firstChild){
					itemEl.removeChild(itemEl.firstChild)
				}
				
				console.log(resp.data)
				const data = resp.data;
				
				const cnt = data.replyCnt; // 댓글 수 최신화
				const replyCntEl = document.querySelector(".reply-cnt");
				replyCntEl.innerHTML=cnt;
				
				
				const items = data.replyList; // 해당 bookCode에 대한 모든 내용을 저장한 list
				items.forEach((item)=>{ // items 는 bookCode와 일치하는 list이다.
					createReplyItem(item)
				})
			 })
			 .catch((error)=>{console.log(error)})
}
receiveReplyData();

function createReplyItem(item){
	const itemEl = document.createElement('div');
	itemEl.className='item';
	
	const leftEl = document.createElement('div');
	leftEl.className='left';
	
	const profileEl = document.createElement('div');
	profileEl.className='profile';
	
	const usernameEl = document.createElement('div');
	usernameEl.className='username';
	usernameEl.innerHTML=item.username;
	
	const rightEl = document.createElement('div');
	rightEl.className='right';
	
	const dateEl = document.createElement('div');
	dateEl.className='date';
	dateEl.innerHTML=item.createAt;
	
	const contentEl = document.createElement('div');
	contentEl.className='content';
	
	const textAreaEl = document.createElement('textarea');
	textAreaEl.value= item.contents;
	
	const buttonGroupEl = document.createElement('div');
	buttonGroupEl.className='button-group';
	
	// 연결
	leftEl.appendChild(profileEl);
	leftEl.appendChild(usernameEl);
	
	contentEl.appendChild(textAreaEl);
	rightEl.appendChild(dateEl);
	rightEl.appendChild(contentEl);
	rightEl.appendChild(buttonGroupEl);
	
	itemEl.appendChild(leftEl);
	itemEl.appendChild(rightEl);
	
	const itemsEl = document.querySelector('.items');
	itemsEl.appendChild(itemEl);
	
	
	
}