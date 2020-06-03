MODULE = "Bitrate"
DESCRIPTION = "Bitrate viewer"

require conf/license/license-gplv2.inc
require openplugins-replace-vision.inc
require openplugins.inc

inherit autotools gettext

DEPENDS += "python"

EXTRA_OECONF = " \
    STAGING_INCDIR=${STAGING_INCDIR} \
    STAGING_LIBDIR=${STAGING_LIBDIR}"

FILES_${PN} = "${libdir} ${bindir}"
