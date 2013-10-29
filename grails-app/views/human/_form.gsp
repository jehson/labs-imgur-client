<%@ page import="labs.imgur.client.Human" %>



<div class="fieldcontain ${hasErrors(bean: humanInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="human.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${humanInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: humanInstance, field: 'picture', 'error')} ">
	<label for="picture">
		<g:message code="human.picture.label" default="Picture" />
		
	</label>
	<input type="file" id="picture" name="picture" />
</div>

