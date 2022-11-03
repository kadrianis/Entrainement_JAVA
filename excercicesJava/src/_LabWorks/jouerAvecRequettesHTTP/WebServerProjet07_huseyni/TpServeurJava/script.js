// getting all required elements
const searchInput = document.querySelector(".search-input");
const inputBox = searchInput.querySelector("input");
const suggestionBox = searchInput.querySelector(".autocom-box");
const icon = searchInput.querySelector(".icon");
let linkForSendData = searchInput.querySelector("a");
let webLink;


// event managing

// if user press any key and release

inputBox.onkeyup = (e)=>{
    let userData = e.target.value; //user enetered data
    let emptyArray = [];
    if(userData){
        //icon.onclick = ()=>{}
         /*   webLink = `file:///home/ousseini/Desktop/Programmation%20JAVA/TpMiniServeurJava/header.html?search=${userData}`;
            //linkForSendData.setAttribute("href", webLink);
            //linkForSendData.click(); 
            
        }*/
        emptyArray = suggestions.filter((data)=>{
            //filtering array value and user characters to lowercase and return only those words which are start with user enetered chars
            return data.toLocaleLowerCase().startsWith(userData.toLocaleLowerCase());
        });
        emptyArray = emptyArray.map((data)=>{
            // passing return data inside li tag
            return data = `<li>${data}</li>`;
        });
        searchInput.classList.add("active"); //show autocomplete box
        showSuggestions(emptyArray);
        let allList = suggestionBox.querySelectorAll("li");
        for (let i = 0; i < allList.length; i++) {
            //adding onclick attribute in all li tag
            allList[i].setAttribute("onclick", "select(this)");
            // adding on up or down
            
        }
    }else{
        searchInput.classList.remove("active"); //hide autocomplete box
    }
}

function select(element){
    let selectData = element.textContent;
    inputBox.value = selectData;
    //icon.onclick = ()=>{}
        //'<input type= submit'>
        //webLink = `file:///home/ousseini/Desktop/Programmation%20JAVA/TpMiniServeurJava/header.html?search=${userData}`;
        //linkForSendData.setAttribute("href", webLink);
        //linkForSendData.click();
    
    searchInput.classList.remove("active");
}

function showSuggestions(list){
    let listData;
    if(!list.length){
        userValue = inputBox.value;
        listData = `<li>${userValue}</li>`;
    }else{
      listData = list.join('');
    }
    suggestionBox.innerHTML = listData;
}
