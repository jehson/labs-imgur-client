package labs.imgur.client

import labs.imgur.services.AnonUploadService
import org.springframework.dao.DataIntegrityViolationException

class HumanController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    
    AnonUploadService anonUploadService
    
    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [humanInstanceList: Human.list(params), humanInstanceTotal: Human.count()]
    }

    def create() {
        [humanInstance: new Human(params)]
    }

    def save() {
        def humanInstance = new Human(params)
	humanInstance.pictureLink = anonUploadService.uploadImageAndGetLink(humanInstance.picture)
	
	if (humanInstance.pictureLink != null) {
            if (!humanInstance.save(flush: true)) {
                render(view: "create", model: [humanInstance: humanInstance])
                return
            }
            flash.message = message(code: 'default.created.message', args: [message(code: 'human.label', default: 'Human'), humanInstance.id])
            redirect(action: "show", id: humanInstance.id)
	} else {
	    render(view: "create", model: [humanInstance: humanInstance])
	    flash.message = message(code: 'default.imgur.inaccessible')
	    return
	}
    }

    def show(Long id) {
        def humanInstance = Human.get(id)
        if (!humanInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'human.label', default: 'Human'), id])
            redirect(action: "list")
            return
        }

        [humanInstance: humanInstance]
    }

    def edit(Long id) {
        def humanInstance = Human.get(id)
        if (!humanInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'human.label', default: 'Human'), id])
            redirect(action: "list")
            return
        }

        [humanInstance: humanInstance]
    }

    def update(Long id, Long version) {
        def humanInstance = Human.get(id)
        if (!humanInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'human.label', default: 'Human'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (humanInstance.version > version) {
                humanInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'human.label', default: 'Human')] as Object[],
                          "Another user has updated this Human while you were editing")
                render(view: "edit", model: [humanInstance: humanInstance])
                return
            }
        }

        humanInstance.properties = params
	humanInstance.pictureLink = anonUploadService.uploadImageAndGetLink(humanInstance.picture)
	    
        if (!humanInstance.save(flush: true)) {
            render(view: "edit", model: [humanInstance: humanInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'human.label', default: 'Human'), humanInstance.id])
        redirect(action: "show", id: humanInstance.id)
    }

    def delete(Long id) {
        def humanInstance = Human.get(id)
        if (!humanInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'human.label', default: 'Human'), id])
            redirect(action: "list")
            return
        }

        try {
            humanInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'human.label', default: 'Human'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'human.label', default: 'Human'), id])
            redirect(action: "show", id: id)
        }
    }
}
