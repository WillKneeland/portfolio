$(function(typedelem).typed({
 		strings: [" Learn how to use UNIX!"],
 		typeSpeed: 15
 	});
 });

jQuery(document).ready(function($){
    $('.type').typeIt({content : 'Learn how to use UNIX!'});
});


document.addEventListener('DOMContentLoaded', 
    function(){
      Typed.new('.entry', {
        strings: ["Learning how to code?", "Do you feel like giving up?", "Don't stop! keep going.", "You will get there."],
        typeSpeed: 1
      });
  });
  