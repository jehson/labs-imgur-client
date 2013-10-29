
<%@ page import="labs.imgur.client.Human" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'human.label', default: 'Human')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-human" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-human" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list human">
			
				<g:if test="${humanInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="human.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${humanInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${humanInstance?.picture}">
				
				<li class="fieldcontain">
					<span id="picture-label" class="property-label"><g:message code="human.picture.label" default="Picture" /></span>
					
					<span class="property-value" aria-labelledby="picture-label">
					
					<img src="${humanInstance?.pictureLink}" /></span>	
				</li>
				
				</g:if>
					
				<g:if test="${humanInstance?.pictureLink}">
				<li class="fieldcontain">
					<span id="pictureLink-label" class="property-label"><g:message code="human.pictureLink.label" default="Picture Link" /></span>
					
					<span class="property-value" aria-labelledby="pictureLink-label"><g:fieldValue bean="${humanInstance}" field="pictureLink"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${humanInstance?.id}" />
					<g:link class="edit" action="edit" id="${humanInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
