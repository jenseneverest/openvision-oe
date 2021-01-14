SUMMARY = "E2i Player for E2"
DESCRIPTION = "E2i Player for E2"
SECTION = "multimedia"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/persianpros/e2iplayer.git;protocol=http"

S = "${WORKDIR}/git"

inherit gitpkgv allarch distutils-openplugins gettext

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

DEPENDS = "gettext-native ${PYTHONNAMEONLY}"

RDEPENDS_${PN} = " \
	cmdwrapper \
	duktape \
	f4mdump \
	ffmpeg \
	hlsdl \
	iptvsubparser \
	lsdir \
	${PYTHONNAMEONLY}-compression \
	${PYTHONNAMEONLY}-core \
	${PYTHONNAMEONLY}-e2icjson \
	${PYTHONNAMEONLY}-html \
	${PYTHONNAMEONLY}-json \
	${PYTHONNAMEONLY}-pycurl \
	${PYTHONNAMEONLY}-shell \
	${@bb.utils.contains("PYTHONEXACTVERSION", "python3", "", " \
	python-subprocess \
	python-textutils", d)} \
	rtmpdump \
	uchardet \
	wget \
	${@bb.utils.contains("MACHINE_FEATURES", "libeplayer", "", "exteplayer3 gst-ifdsrc gstplayer", d)} \
	"

RDEPENDS_{PN}-src = "${PN}"

deltask package_qa

FILES_${PN} += "${sysconfdir}"

do_install_append() {
	install -d ${D}${sysconfdir}
	cp -fr ${S}/vk ${D}${sysconfdir}/vk
}
