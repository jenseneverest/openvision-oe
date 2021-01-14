DESCRIPTION = "A template for writing your own GStreamer plug-in"
MAINTAINER = "samsamsam"

DEPENDS = "${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer1.0", "gstreamer", d)} ${GSTVNAME}-plugins-base"

require conf/license/openvision-gplv2.inc
inherit gitpkgv autotools pkgconfig

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

SRC_URI = "git://gitlab.com/e2i/gst-ifdsrc.git;protocol=http"

S = "${WORKDIR}/git/"

FILES_${PN} += "${libdir}/gstreamer-${GST_VERSION}"
