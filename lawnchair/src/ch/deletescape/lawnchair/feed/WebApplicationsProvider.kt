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

package ch.deletescape.lawnchair.feed

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.webkit.WebView
import android.widget.TextView
import ch.deletescape.lawnchair.lawnchairPrefs
import ch.deletescape.lawnchair.runOnNewThread
import io.github.cdimascio.essence.Essence
import org.apache.commons.io.IOUtils
import java.io.IOException
import java.net.URL
import java.nio.charset.Charset

class WebApplicationsProvider(context: Context) : FeedProvider(context) {
    val viewCache = mutableMapOf<URL, WebView>()
    override fun onFeedShown() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFeedHidden() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDestroy() {
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun getCards(): List<Card> {
        return context.lawnchairPrefs.feedWebApplications.mapNotNull {
            Card(null, it.title, { v, _ ->
                if (!it.isArticle) {
                    if (viewCache.containsKey(it.url)) viewCache[it.url]!! else WebView(
                            context).apply {
                        settings.javaScriptEnabled = true
                        loadUrl(Uri.decode(it.url.toURI().toASCIIString()))
                        viewCache += it.url to this
                    }
                } else {
                    TextView(v.context).apply {
                        runOnNewThread {
                            try {
                                val loadedText = Essence.extract(
                                        IOUtils.toString(it.url.openStream(),
                                                         Charset.defaultCharset())).text
                                post {
                                    text = loadedText
                                }
                            } catch (e: IOException) {
                                text = e.localizedMessage
                            }
                        }
                    }
                }
            }, Card.RAISE, if (it.sort) "" else "nosort,top", it.url.hashCode())
        }
    }
}