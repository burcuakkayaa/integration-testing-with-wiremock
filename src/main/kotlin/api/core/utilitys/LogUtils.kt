package api.core.utilitys

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class LogUtils {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger("logback")

        private val sb = StringBuilder()

        fun logInfo(message: String) {
            sb.append(message)
            logger.info(message)
        }

        fun logError(message: String) {
            sb.append(message)
            logger.error(message)
        }

        fun logDebug(message: String) {
            sb.append(message)
            logger.debug(message)
        }

        fun logWarn(message: String) {
            sb.append(message)
            logger.warn(message)
        }
    }
}
