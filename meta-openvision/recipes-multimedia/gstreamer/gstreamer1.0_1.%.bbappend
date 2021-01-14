FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0003-meson-Add-valgrind-feature.patch \
	file://0005-revert-use-new-gst-adapter-get-buffer.patch \
	${@bb.utils.contains("MACHINE", "dm800", "file://disable-mutex.patch", "", d)} \
	"

SRC_URI_remove += "file://0002-Remove-unused-valgrind-detection.patch"

EXTRA_OEMESON += "\
	${GSTREAMER1_DEBUG} \
	${@bb.utils.contains_any("MACHINE", "cube su980", "-Dc_std=gnu99", "", d)} \
	"

CFLAGS_append_cube = " -std=gnu99"
CFLAGS_append_su980 = " -std=gnu99"
