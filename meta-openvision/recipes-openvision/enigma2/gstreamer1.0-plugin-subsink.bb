DESCRIPTION = "gstreamer subsink plugin"
SECTION = "multimedia"
PRIORITY = "optional"
DEPENDS = "glib-2.0-native gstreamer1.0 gstreamer1.0-plugins-base"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=7fbc338309ac38fefcd64b04bb903e34"

SRC_URI = "git://github.com/christophecvr/gstreamer1.0-plugin-subsink.git;protocol=git"

S = "${WORKDIR}/git"

inherit gitpkgv autotools pkgconfig

PV = "${GST_VERSION}+git${SRCPV}"
PKGV = "${GST_VERSION}+git${GITPKGV}"

EXTRA_OECONF = "--with-gstversion=${GST_VERSION}"

FILES_${PN} = "${libdir}/gstreamer-${GST_VERSION}/*.so*"
FILES_${PN}-dev += "${libdir}/gstreamer-${GST_VERSION}/*.la"
FILES_${PN}-staticdev += "${libdir}/gstreamer-${GST_VERSION}/*.a"
FILES_${PN}-dbg += "${libdir}/gstreamer-${GST_VERSION}/.debug"
