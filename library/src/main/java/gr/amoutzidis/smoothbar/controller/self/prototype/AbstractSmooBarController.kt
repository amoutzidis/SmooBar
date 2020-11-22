package gr.amoutzidis.smoothbar.controller.self.prototype

import gr.amoutzidis.smoothbar.controller.self.prototype.SmooBarController
import gr.amoutzidis.smoothbar.widgets.SmooBarCallback
import gr.amoutzidis.smoothbar.widgets.SmooBarIntCallback

abstract class AbstractSmooBarController: SmooBarController {

    protected var stopTrackingCallback: SmooBarCallback?= null
    protected var startTrackingCallback: SmooBarCallback?= null
    protected var onChangedCallback: SmooBarIntCallback?= null

    override fun onChangedCallback(callback: SmooBarIntCallback) {
        this.onChangedCallback = callback
    }

    override fun stopTrackingCallback(callback: SmooBarCallback) {
        this.stopTrackingCallback = callback
    }

    override fun startTrackingCallback(callback: SmooBarCallback) {
        this.startTrackingCallback = callback
    }

}