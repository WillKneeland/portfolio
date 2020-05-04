var optionData;     //JSON of the list of options
var optionLength;   //length of all the objects in the JSON data

//create the page
function create() {
    optionData = options.options;

    //log data for created var optionData
    console.log(optionData);
    console.log("Object.key(optionData) " + Object.keys(optionData));
    console.log("Object.key(optionData).length " + Object.keys(optionData).length);

    //gathers length of the data in JSON object
    optionLength = Object.keys(optionData).length;

    makeForm();
    makeSelectionElements("Base");

    //makes form function
    function makeForm() {

        var form = document.createElement('form');
        form.setAttribute('method',"post");
        form.setAttribute('action',"Save");
        form.id = "formId";
        //console.log("form Id: " + form.id);
    
        var formHead = document.createElement('h2');
        var formHeadText = document.createTextNode("Please Enter The Following Information");
        formHead.appendChild(formHeadText);
        form.appendChild(formHead);
        //console.log("formHead: " + formHeadText);

        var formFirstName = document.createElement('p');
        var formFirstNameText = document.createTextNode("First Name: ");
        formFirstName.appendChild(formFirstNameText);
        //console.log("formFirstNameText: " + formFirstNameText);

        var firstNameInput = document.createElement('input');
        firstNameInput.type = "text";
        firstNameInput.name = "firstName";
        firstNameInput.id = "firstNameId";
        formFirstName.appendChild(firstNameInput);
        form.appendChild(formFirstName);
        //console.log("formFirstNameInput: " + firstNameInput.name);

        var formLastName = document.createElement('p');
        var formLastNameText = document.createTextNode("Last Name: ");
        formLastName.appendChild(formLastNameText);
        //console.log("formLastName: " + formLastNameText);

        var lastNameInput = document.createElement('input');
        lastNameInput.type = "text";
        lastNameInput.name = "lastName";
        lastNameInput.id = "lastNameId";
        formLastName.appendChild(lastNameInput);
        form.appendChild(formLastName);
        //console.log("formLastNameInput: " + lastNameInput.name);

        var formEmail = document.createElement('p');
        var formEmailText = document.createTextNode("Email: ");
        formEmail.appendChild(formEmailText);
        //console.log("formEmail: " + formEmailText);

        var emailInput = document.createElement('input');
        emailInput.type = "text";
        emailInput.name = "email";
        emailInput.id = "emailId";
        formEmail.appendChild(emailInput);
        form.appendChild(formEmail);
        //console.log("formEmailInput: " + emailInput.name);

        /*var formDummy = document.createElement('div');

        var save = document.createElement('button');
        var saveText = document.createTextNode("Save In Cookies");
        save.id = "saveButton";
        //save.type = "submit";
        save.value = "Save In Cookies";
        save.appendChild(saveText);
        formDummy.appendChild(save);

        var clear = document.createElement('button');
        var clearText = document.createTextNode("Clear Past Information");
        clear.id = "clearButton";
        //clear.type = "submit";
        clear.value = "Clear Past Information";
        clear.appendChild(clearText);
        formDummy.appendChild(clear);

        save.addEventListener("click", function(){ storeFormValues(form); } );
        clear.addEventListener("click", function(){ clearCookies(form); } );

        form.appendChild(formDummy);
        //console.log("formClearButton: " + clear.value);

        if(firstName = getCookie("firstName")) document.form.firstName.value = firstName;*/

        formDiv.appendChild(form);
    }

    //makes the selection elements
    function makeSelectionElements(dataKey) {

        for (var i = 0; i < optionLength; i++) {

                //if the option does not match the key, skip the option
                if (optionData[i].key != dataKey) {
                    continue;
                }
            
                //if(i < 4){
            
                    //log key
                    console.log("optionData[i].key: " + optionData[i].key);

                    //creates header label for specific element
                    var h3 = document.createElement('h3');
                    var text = document.createTextNode(optionData[i].description);
                    h3.className = optionData[i].depth;
                    h3.appendChild(text);
                    selectionDiv.appendChild(h3);

                    //log creation
                    //console.log("h3: " + h3.name);

                    //create the selection list element
                    var selectionList = document.createElement('select');
                    selectionList.id = optionData[i].key;
                    selectionList.name = optionData[i].description;
                    selectionList.className = optionData[i].depth;
                    selectionDiv.appendChild(selectionList);

                    /*if (localStorage.getItem(4) != ""){
                        h3.className = 4;
                        selectionList.className = 4;
                        fixSelectionList();
                    }*/

                    //log creation
                    //console.log("selectionList: " + selectionList.name);

                    //create dummy selection option
                    var dummyOption = document.createElement('option');
                    dummyOption.text = "Select an Option";
                    dummyOption.selected = this;
                    dummyOption.disabled = true;
                    selectionList.appendChild(dummyOption);

                    //log creation
                    //console.log("dummyOption: " + dummyOption.text);

                    //create option 1 
                    var option1 = document.createElement('option');
                    option1.id = optionData[i].option_1;
                    option1.value = optionData[i].option_1;
                    option1.text = optionData[i].option_1;
                    selectionList.appendChild(option1);

                    //log creation
                    //console.log("option1: " + option1.text);

                    //create option 2 
                    var option2 = document.createElement('option');
                    option2.id = optionData[i].option_2;
                    option2.value = optionData[i].option_2;
                    option2.text = optionData[i].option_2;
                    selectionList.appendChild(option2);

                    if(h3.className == 4){
                        //console.log("if is called");
                        //hides the 5th selection list
                        selectionList.style.visibility = "hidden";

                        //adds image for the page
                        //var imgTag = document.createElement('IMG');
                        var image = new Image();
                        //var src = optionData[i].image;
                        //console.log("" + src);
                        image.className = optionData[i].depth;
                        image.src = optionData[i].image;
                        image.alt = "Cannot Find Image";
                        image.height = 200;
                        image.width = 325;
                        image.style.opacity = 0;
                        //image.style.margin-left = 100;
                        //image.style.margin = 50;
                        //image.style.position = "center";
                        //image.style.padding = 100;
                        //imgTag.appendChild(image);
                        selectionDiv.appendChild(image);

                        //fades in the image with the fadein function
                        fadeIn(image);

                        //makeYoutubeVideo();
                        
                        /*var iframe = document.createElement("iframe");
                        iframe.setAttribute("src", "" + youtube + "?autoplay=1");
                        iframe.className = optionData[i].depth;
                        iframe.height = 185;
                        iframe.width = 250;
                        selectionDiv.appendChild(iframe);*/
                    }

                    //fade in function for elements
                    function fadeIn(element){
                        var opacity = 1;
                        var timer = setInterval(function () {
                            if (opacity >= 1){
                                clearInterval(timer);
                            }
                            element.style.opacity = opacity;
                            element.style.filter = "alpha(opacity=" + opacity * 100 + ")";
                            opacity += opacity * 0.1;
                        }, 10);
                    }
                //}
                /*if(i == 4) {
                    var endHead = document.createElement('h2');
                    var endText = document.createTextNode(optionData[i].description);
                    endHead.className = optionData[i].depth;
                    endHead.appendChild(endText);
                    selectionDiv.appendChild(endHead);

                    document.getElementById(optionData[i].key).style.visibility = "hidden";
                }*/

                /*
                if (selectionList.className == 3) {
                    document.getElementById(selectionList.id).addEventListener('click', function(){ finish(); });
                }

                function finish() {

                    console.log("Finish");
                    //console.log(selectedList.selected);
                    var options = selectionList.querySelectorAll('option');
                    if(selectionList.selected == options[1]){
                        finish1();
                    }
                    if(selectionList.selected == options[2]){
                        finish2();
                    }
                }

                function finish1() {

                    console.log("Finish1");
                    var endHead = document.createElement('h2');
                    var endText = document.createTextNode("A Professional Game You May Be Interested In Is: " + optionData[i].answer1);
                    endHead.className = optionData[i].answer1;
                    endHead.appendChild(endText);
                    selectionDiv.appendChild(endHead);
                }
                
                function finish2() {

                    console.log("Finish2");
                    var endHead = document.createElement('h2');
                    var endText = document.createTextNode("A Professional Game You May Be Interested In Is: " + optionData[i].answer2);
                    endHead.className = optionData[i].answer2;
                    endHead.appendChild(endText);
                    selectionDiv.appendChild(endHead);
                }
                */

            //fixes the function if an option is changed
            selectionList.onchange = fixSelectionList;
        } //end of for loop
    } //end of makeSelectionElements

    //changes the selection element if a selection is changed
    function fixSelectionList() {
        console.log(this);
        console.log("this.className: " + this.className);
        console.log("this.value: " + this.value);

        //console.log("calling killElements");
        //removes elements
        killElements(this.className);

        //creates new elements
        makeSelectionElements(this.value);

        //assign recent selection value
        recentSelection = this;
    }; //end of fixSelectionList

    //removes all children from selectionDiv
    function clearDiv() {
        //checks if a child exists in the first child slot, and removes it if it exists
        while (selectionDiv.firstChild) {
            selectionDiv.removeChild(selectionDiv.firstChild);
        } //end of while loop
    }; //end of removeChildElements

    //removes elements based on the depth of the question
    function killElements(elementDepth) {
        //console.log("killElements was called");
        //gets the current depth
        var currentDepth = parseInt(elementDepth);
        //console.log("currentDepth defined: " + currentDepth);

        //loops through any elements with a deeper depth than the current
        //console.log("loops starting");
        for (var i = 4; i > currentDepth; i--) {
            //gets elements of given depth
            //console.log("for loop iteration " + i);
            var elementsToKill = document.getElementsByClassName(i);

            //kills all the target elements
            while (elementsToKill.length > 0) {
                
                elementsToKill[0].parentNode.removeChild(elementsToKill[0]);
            } //end of while loop
        } //end of for loop
    }; //end of killElements
} //end of create

window.onload = create;