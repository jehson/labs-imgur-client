package labs.imgur.client



import org.junit.*
import grails.test.mixin.*

@TestFor(HumanController)
@Mock(Human)
class HumanControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/human/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.humanInstanceList.size() == 0
        assert model.humanInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.humanInstance != null
    }

    void testSave() {
        controller.save()

        assert model.humanInstance != null
        assert view == '/human/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/human/show/1'
        assert controller.flash.message != null
        assert Human.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/human/list'

        populateValidParams(params)
        def human = new Human(params)

        assert human.save() != null

        params.id = human.id

        def model = controller.show()

        assert model.humanInstance == human
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/human/list'

        populateValidParams(params)
        def human = new Human(params)

        assert human.save() != null

        params.id = human.id

        def model = controller.edit()

        assert model.humanInstance == human
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/human/list'

        response.reset()

        populateValidParams(params)
        def human = new Human(params)

        assert human.save() != null

        // test invalid parameters in update
        params.id = human.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/human/edit"
        assert model.humanInstance != null

        human.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/human/show/$human.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        human.clearErrors()

        populateValidParams(params)
        params.id = human.id
        params.version = -1
        controller.update()

        assert view == "/human/edit"
        assert model.humanInstance != null
        assert model.humanInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/human/list'

        response.reset()

        populateValidParams(params)
        def human = new Human(params)

        assert human.save() != null
        assert Human.count() == 1

        params.id = human.id

        controller.delete()

        assert Human.count() == 0
        assert Human.get(human.id) == null
        assert response.redirectedUrl == '/human/list'
    }
}
