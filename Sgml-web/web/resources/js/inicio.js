/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    $("#boton-registro").click(function(){
        $("#modal-signup").modal({
            "backdrop" : "static",
            "show" : true
        });
    });
   
    $('#navbar-usuario a').click(function (e) {
        e.preventDefault();
        $(this).tab('show');
    }) 
   
});

