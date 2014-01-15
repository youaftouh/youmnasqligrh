
$(function() {
	$.datepicker.setDefaults({
		dateFormat : 'dd/mm/yy'
	});

	$("#date_embauche").datepicker();
	$("#date_depart").datepicker();
	$("#date_particp").datepicker();
});
var rowTech= 0;
var rowComp= 2;
var rowNum = 0;
function addRow() {
	rowNum++;
	var row = '<p id="rowNum'
			+ rowNum
			+ '"><table id="tabcol" align="center"><hr> <tr><td><label>Titre:</label></td><td><input name="DIPLOME['+rowNum+'].nom" /></td><td><label>Ecole:</label></td><td><input name="DIPLOME['+rowNum+'].ecole" /></td><td><label>Ecole type:</label></td><td><select name="DIPLOME['+rowNum+'].ecoleType" id="combobox"><option value="National">National</option><option value="International">International</option></select></td></tr><tr><td><label>Diplome type:</label></td><td><select name="DIPLOME['+rowNum+'].diplomeType"><option value="etatique">etatique</:option><option value="prive">prive</option></select></td><td><label>Promotion:</label></td><td><input name="DIPLOME['+rowNum+'].promotion" /></td><td><label>Niveau:</label></td><td><input name="DIPLOME['+rowNum+'].niveau" id="niveau"/></td></tr></table></p>';

	jQuery('#itemRows').append(row);
	$("#removeDip").removeAttr('disabled').removeClass( 'ui-state-disabled' );
}


function removeRow() {
	jQuery('#rowNum' + rowNum).remove();
	rowNum--;
	if(rowNum==0){
		$("#removeDip").attr('disabled', 'disabled' ).addClass( 'ui-state-disabled' );
	}
}

function addTech() {
	rowTech++;
	rowComp++;
	var row = '<p id="rowTech'
			+ rowTech
			+ '"><table align="center"><hr><tr><td><label>Technologie:</label></td><td><input name="TECHNOLOGIE['+rowTech+'].technologie" id="techno" /></td><td><label>Competence #1:</label></td><td><input name="COMPETENCE['+rowComp+'].competence" /></td><td><label>Niveau d\'expertise:</label></td><td><input name="COMPETENCE['+rowComp+'].niveauExpertise" /></td></tr><tr><td></td><td></td><td><label>Competence #2:</label></td><td><input name="COMPETENCE['+rowComp+'].competence" /></td><td><label>Niveau d\'expertise:</label></td><td><input name="COMPETENCE['+rowComp+'].niveauExpertise" /></td></tr><tr><td></td><td></td><td><label>Competence #3:</label></td><td><input name="COMPETENCE['+rowComp+'].competence" /></td><td><label>Niveau d\'expertise:</label></td><td><input name="COMPETENCE['+rowComp+'].niveauExpertise" /></td></tr></table></p>';

	jQuery('#itemTech').append(row);
	$("#removeTech").removeAttr('disabled').removeClass( 'ui-state-disabled' );
}

function remove2() {
	jQuery('#rowTech' + rowTech).remove();
	rowTech--;
	rowComp--;
	if(rowTech==0){
		$("#removeTech").attr('disabled', 'disabled' ).addClass( 'ui-state-disabled' );
	}
}

function go(url) {
	window.location = url;
}


$(document).ready(function() {

    var numPages = $('.form_page').length;
    var currentPage = 1;
    var $actions = $('#actions');
    for(i = 2; i <= numPages; i++) {
     
        $('#page' + i).hide();     
    }
    $("#previous").attr('disabled', 'disabled' ).addClass( 'ui-state-disabled' );
    
     $('#previous').click(function() {
        
        if (currentPage > 1) {
            
            $('#page' + currentPage).hide();
            currentPage--;
            $('#page' + currentPage).show();
        }
    	if(currentPage==numPages){
    		$("#next").attr('disabled', 'disabled' ).addClass( 'ui-state-disabled' );
    	}
    	if(currentPage==3){
    		$("#next").removeAttr('disabled').removeClass( 'ui-state-disabled' );
    	}
    	if(currentPage==1){
    		$("#previous").attr('disabled', 'disabled' ).addClass( 'ui-state-disabled' );
    	}

    }).appendTo($actions);

     $('#next').click(function() {
    	 
    	 
        if (currentPage < numPages) {

            
            $('#page' + currentPage).hide();
            currentPage++;

            $('#page' + currentPage).show();
        }
    	if(currentPage==numPages){
    		$("#next").attr('disabled', 'disabled' ).addClass( 'ui-state-disabled' );
    	}
    	if(currentPage==2){
    		$("#previous").removeAttr('disabled').removeClass( 'ui-state-disabled' );
    	}

    }).appendTo($actions);
});