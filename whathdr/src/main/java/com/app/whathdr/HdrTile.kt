package com.app.whathdr

import android.content.Intent
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService

class HdrTile: TileService() {

    // Called when your app can update your tile.
    override fun onStartListening() {
        super.onStartListening()
        updateTileState()
    }

    // Called when the user taps on your tile in an active or inactive state.
    override fun onClick() {
        super.onClick()
        val tile = qsTile?: return
        //if click is not supported, its ignored
        if(!MainActivity.AppState.isHdrSupported) return

        val isActivated = (tile.state == Tile.STATE_ACTIVE)
        val intent = Intent(this, HDRService::class.java)
        if (isActivated) {
            intent.action = HDRService.Actions.STOP.toString()
            tile.state = Tile.STATE_INACTIVE
        }
        else {
            intent.action = HDRService.Actions.START.toString()
            tile.state = Tile.STATE_ACTIVE
        }
        this.startService(intent)
        tile.updateTile()
    }

    private fun updateTileState() {
        val myTile = qsTile?: return

        if(!MainActivity.AppState.isHdrSupported) {
            myTile.state = Tile.STATE_UNAVAILABLE
            myTile.updateTile()
            return
        }
        myTile.state = if (HDRService.isRunning) {
            Tile.STATE_ACTIVE
        } else {
            Tile.STATE_INACTIVE
        }
        myTile.updateTile()
    }
}