package api.core.utilitys

import api.controller.model.Sample
import org.apache.commons.io.IOUtils
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.StandardCharsets

class SampleReaderUtils {

    companion object {
        private val samplePath = "samples/"

        fun string(sample: Sample): String {
            val samplePath = samplePath + sample.path
            val inStream = ClassLoader.getSystemResourceAsStream(samplePath)
            return try {
                IOUtils.toString(inStream, StandardCharsets.UTF_8.name())
            } catch (e: IOException) {
                e.printStackTrace()
                ""
            }
        }

        fun json(sample: Sample): JSONObject {
            val samplePath = samplePath + sample.path
            val inStream = ClassLoader.getSystemResourceAsStream(samplePath)
            return try {
                JSONObject(IOUtils.toString(inStream, StandardCharsets.UTF_8.name()))
            } catch (e: IOException) {
                e.printStackTrace()
                JSONObject()
            }
        }
    }
}
