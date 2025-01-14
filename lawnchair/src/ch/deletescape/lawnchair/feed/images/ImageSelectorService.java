/*
 *     Copyright (c) 2017-2019 the Lawnchair team
 *     Copyright (c)  2019 oldosfan (would)
 *     This file is part of Lawnchair Launcher.
 *
 *     Lawnchair Launcher is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Lawnchair Launcher is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Lawnchair Launcher.  If not, see <https://www.gnu.org/licenses/>.
 */

package ch.deletescape.lawnchair.feed.images;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import ch.deletescape.lawnchair.IImageSelector;
import ch.deletescape.lawnchair.LawnchairLauncher;
import ch.deletescape.lawnchair.feed.IImageStoreCallback;
import com.android.launcher3.Launcher;
import java.util.Objects;

public class ImageSelectorService extends Service {

    private IImageSelector.Stub selector;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return selector != null ? selector : (selector = new IImageSelector.Stub() {
            @Override
            public void selectImage(IImageStoreCallback callback) throws RemoteException {
                if (Launcher.getLauncherOrNull(getApplicationContext()) == null) {
                    callback.onImageRetrieved(null);
                } else {
                    ((LawnchairLauncher) Objects
                            .requireNonNull(Launcher.getLauncherOrNull(getApplicationContext()))).selectImage(callback);
                }
            }
        });
    }
}
