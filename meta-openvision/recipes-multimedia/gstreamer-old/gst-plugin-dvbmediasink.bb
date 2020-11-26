SUMMARY = "gstreamer dvbmediasink plugin"
SECTION = "multimedia"
PRIORITY = "optional"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=7fbc338309ac38fefcd64b04bb903e34"

# Most machine recipes still (r)depend on gst-plugin-dvbmediasink
RPROVIDES_${PN} = "gst-plugin-dvbmediasink"

PROVIDES += "virtual/gst-mediasink"
RPROVIDES_${PN} += "virtual/gst-dvbmediasink"

DEPENDS = "gstreamer ${GSTVNAME}-plugins-base libdca"

SRC_URI = "git://github.com/OpenPLi/gst-plugin-dvbmediasink.git;branch=master;protocol=git"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit gitpkgv autotools pkgconfig

PV = "0.10.0+git${SRCPV}"
PKGV = "0.10.0+git${GITPKGV}"

do_configure_prepend() {
    touch ${S}/NEWS
    touch ${S}/README
    touch ${S}/AUTHORS
    touch ${S}/ChangeLog
}

FILES_${PN} = "${libdir}/gstreamer-0.10/*.so*"
FILES_${PN}-dev += "${libdir}/gstreamer-0.10/*.la"
FILES_${PN}-staticdev += "${libdir}/gstreamer-0.10/*.a"
FILES_${PN}-dbg += "${libdir}/gstreamer-0.10/.debug"

PACKAGE_ARCH = "${MACHINE_ARCH}"

EXTRA_OECONF = "${DVBMEDIASINK_CONFIG}"
