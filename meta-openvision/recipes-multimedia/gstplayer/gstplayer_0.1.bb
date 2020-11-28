DESCRIPTION = "gstplayer by samsamsam"
SECTION = "multimedia"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS = "gstreamer ${GSTVNAME}-plugins-base"

inherit pkgconfig

SRC_URI = "git://gitlab.com/e2i/gstplayer.git;protocol=http \
	file://0001-set-iptv-download-timeout-0-to-disable-ifdsrc.patch \
	file://0004-rename-stored-sink-to-dvbSink-for-clarity.patch \
	file://0009-try-to-get-PTS-from-video-sink-first.patch \
	file://0011-increase-eos-fix-timeout-to-10s.patch \
	"

S = "${WORKDIR}/git"

do_compile() {
    cd ${S}/gst-${GST_VERSION}
    ${CC} *.c ../common/*.c -I../common/ `pkg-config --cflags --libs gstreamer-${GST_VERSION} gstreamer-pbutils-${GST_VERSION}` -o gstplayer_gst-${GST_VERSION} ${LDFLAGS}
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/gst-${GST_VERSION}/gstplayer_gst-${GST_VERSION} ${D}${bindir}/gstplayer
}

pkg_postinst_ontarget_${PN}() {
    ln -sf gstplayer ${bindir}/gstplayer_gst-${GST_VERSION}
}

pkg_prerm_${PN}() {
    rm -f ${bindir}/gstplayer_gst-${GST_VERSION}
}
