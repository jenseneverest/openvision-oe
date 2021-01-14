FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0002-subparse-set-need_segment-after-sink-pad-received-GS.patch \
	file://0003-riff-media-added-fourcc-to-all-ffmpeg-mpeg4-video-caps.patch \
	"

do_configure_prepend() {
	find ${S}/ -type f -name "*.wrap" | xargs -r -L1 sed -i "s|https://gitlab.freedesktop.org/gstreamer/meson-ports|https://github.com/persianpros|g"
}

EXTRA_OEMESON += "\
	${GSTREAMER1_DEBUG} \
	${@bb.utils.contains_any("MACHINE", "cube su980", "-Dc_std=gnu99", "", d)} \
	"

CFLAGS_append_cube = " -std=gnu99"
CFLAGS_append_su980 = " -std=gnu99"
