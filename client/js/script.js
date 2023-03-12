const toastTrigger = document.getElementById('liveToastBtn')
const toastLiveExample = document.getElementById('liveToast')
if (toastTrigger) {
  toastTrigger.addEventListener('click', () => {
    const toast = new bootstrap.Toast(toastLiveExample)

    toast.show()
  })
}
var span = document.getElementById("toastito");


let buttonLog = document.getElementById("btn-SignIn")
                              .addEventListener("click", (e) => {
    e.preventDefault();

//     const API_URL = "http://localhost:9090/";
    const API_URL = "http://147.182.242.164:8080/stockmaster/";
    const SIGNIN = API_URL + "auth/signin";
    let iden= (document.getElementById("identifier").value);
    let pass= (document.getElementById("password-signin").value);

    var formdata = new FormData();
    formdata.append("identifier", iden);
    formdata.append("password", pass);

    var requestOptions = {
            method: 'POST',
            body: formdata,
            redirect: 'follow'
    };

    fetch(SIGNIN, requestOptions)
            .then(response => response.text())
            .then(result => {
                                span.textContent = result;
                                const toast = new bootstrap.Toast(toastLiveExample)
                                toast.show()
                                console.log(result);})
            .catch(error => console.log('error', error)
        );
});

// ----------- -------- ------- -------- ------
let buttonReg = document.getElementById("btn-SignUp").addEventListener("click", (e) => {
        e.preventDefault();
    
    //     const API_URL = "http://localhost:9090/";
        const API_URL = "http://147.182.242.164:8080/stockmaster/";
        const SIGNUP = API_URL + "auth/signup";
        let name= (document.getElementById("name").value);
        let user= (document.getElementById("username").value);
        let email= (document.getElementById("email").value);
        let pass= (document.getElementById("password-signup").value);
    
        var formdata = new FormData();
        formdata.append("name", name);
        formdata.append("username", user);
        formdata.append("email", email);
        formdata.append("password", pass);
    
        var requestOptions = {
                method: 'POST',
                body: formdata,
                redirect: 'follow'
        };
    
        fetch(SIGNUP, requestOptions)
                .then(response => response.text())
                .then(result => {
                                    span.textContent = result;
                                    const toast = new bootstrap.Toast(toastLiveExample)
                                    toast.show()
                                    console.log(result);})
                .catch(error => console.log('error', error)
            );
    });
// ----------- -------- ------- -------- ------


        // document.getElementById("reg").onclick = function () {
        //     location.href = "register.html";
        //   };
       
        // let button = document.getElementByClass("btn").addEventListener("click", (e) => {
        //   e.preventDefault();

        //   const API_URL = "http://localhost:9090/";
        //   let iden= (document.getElementById("identifier").value);
        //   let pass= (document.getElementById("password").value);

        //   fetch(`${API_URL}auth/signin?identifier=${iden}&password=${pass}`, {
        //     method: "POST",
        //     headers: {
        //       Accept: "application/json, text/plain, */*",
        //       "Content-Type": "application/json",
        //     }
          

        //   })
        //     .then((response) => response.json())
        //     .then((data) => {
        //       console.log("holiss: "+data.token);
        //       // code here //
        //       if (data.token === null) {
        //         alert("Error Password or Username"); /*displays error message*/
        //       } else {
        //         localStorage.setItem("token", data.token);
        //         // location.href = "target.html";
        //       }
        //     })
        //     .catch((err) => {
        //       console.log(err);
        //     });
        // });

// ----------- -------- ------- -------- ------

        // function validateForm() {
        //   let x = document.forms["myForm"]["fname"].value;
        //   if (x == "") {
        //     alert("Name must be filled out");
        //     return false;
        //   }
        // }
        // const API_URL = 'http://localhost:8080';
        // const HTMLResponse = document.querySelector('#app');

        // fetch(`${API_URL}/library/books/?page=0&limit=10`, {
        //         method: "POST",
        //         headers: {
        //             "Content-type": "application/json;charset=UTF-8"
        //         }
        //     })
        //     .then((response) => response.json())
        //     .then((library) => {
        //     HTMLResponse.innerHTML  = library.map((book) =>   
        //                                        `<div class="card p-2">
        //                                             <h5>${book.isbn}</h5> 
        //                                             <h5>${book.title}</h5> 
        //                                             <h5>${book.category.name}</h5> 
        //                                             <h5>${(book.publishDate).substr(0,10)}</h5>
        //                                         </div>`);
        //     });