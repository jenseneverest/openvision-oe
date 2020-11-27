DESCRIPTION = "gstreamer subsink plugin"
SECTION = "multimedia"
PRIORITY = "optional"
DEPENDS = "gstreamer ${GSTVNAME}-plugins-base glib-2.0-native"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=7fbc338309ac38fefcd64b04bb903e34"

inherit gitpkgv autotools pkgconfig

PV = "0.10.0+git${SRCPV}"
PKGV = "0.10.0+git${GITPKGV}"

SRC_URI = "git://github.com/OpenPLi/gst-plugin-subsink.git"

S = "${WORKDIR}/git"

FILES_${PN} = "${libdir}/gstreamer-0.10/*.so*"
FILES_${PN}-dev += "${libdir}/gstreamer-0.10/*.la"
FILES_${PN}-staticdev += "${libdir}/gstreamer-0.10/*.a"
FILES_${PN}-dbg += "${libdir}/gstreamer-0.10/.debug"
