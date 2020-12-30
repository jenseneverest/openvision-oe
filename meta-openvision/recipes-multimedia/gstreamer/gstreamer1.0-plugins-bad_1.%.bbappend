FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0004-rtmp-hls-tsdemux-fix.patch \
	file://0005-rtmp-fix-seeking-and-potential-segfault.patch \
	file://0006-dvbapi5-fix-old-kernel.patch \
	file://0007-hls-main-thread-block.patch \
	file://0001-Revert-tsdemux-Limit-the-maximum-PES-payload-size.patch \
	file://0002-Revert-tsdemux-always-take-the-seek-segment-stop-int.patch \
	file://0003-Revert-tsdemux-Use-gst_segment_do_seek.patch \
	${@bb.utils.contains("MACHINE", "dm800", "file://006-fix-build-with-glibc219.patch file://allow-api.patch", "", d)} \
	"

DEPENDS += "libva"

EXTRA_OEMESON += "\
	${GSTREAMER1_DEBUG} \
	${@bb.utils.contains("MACHINE", "dm800", "-Duvch264=disabled -Ddecklink=disabled", "", d)} \
	${@bb.utils.contains_any("MACHINE", "cube su980", "-Dc_std=gnu99", "", d)} \
	"

CFLAGS_append_cube = " -std=gnu99"
CFLAGS_append_su980 = " -std=gnu99"
