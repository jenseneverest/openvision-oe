require conf/license/openvision-gplv2.inc

inherit image

DEPENDS += "zip-native"

IMAGE_INSTALL = "\
	${ROOTFS_PKGMANAGE} \
	avahi-daemon \
	ca-certificates \
	distro-feed-configs \
	dropbear \
	e2fsprogs-e2fsck \
	e2fsprogs-mke2fs \
	e2fsprogs-tune2fs \
	fakelocale \
	glibc-binary-localedata-en-gb \
	hdparm \
	kernel-params \
	modutils-loadscript \
	nfs-utils-client \
	openssh-sftp \
	openvision-extra-feed-config \
	openvision-module \
	openvision-version-info \
	opkg \
	ov-permission-helper \
	packagegroup-base \
	packagegroup-core-boot \
	parted \
	${PYTHONNAMEONLY}-ipaddress  \
	${PYTHONNAMEONLY}-netifaces \
	sdparm \
	tuxbox-common \
	tzdata \
	volatile-media \
	vsftpd \
	"

export IMAGE_BASENAME = "openvision"
IMAGE_LINGUAS = ""
IMAGE_FEATURES += "package-management"

# Remove the mysterious var/lib/opkg/lists that appears to be the result
# of the installer that populates the rootfs. I wanted to call this
# rootfs_remove_opkg_leftovers but that fails to parse.
rootfs_removeopkgleftovers() {
   rm -r ${IMAGE_ROOTFS}${localstatedir}/lib/opkg/lists
}

# Speedup boot by reducing the host key size. The time it takes grows
# exponentially by key size, the default is 2k which takes several
# seconds on most boxes.
rootfs_speedup_dropbearkey() {
   echo 'DROPBEAR_RSAKEY_ARGS="-s 1024"' >> ${IMAGE_ROOTFS}${sysconfdir}/default/dropbear
}

# Some features in image.bbclass we do NOT want, so override them
# to be empty. We want to log in as root, but NOT via SSH. So we want
# to live without debug-tweaks...
zap_root_password () {
	true
}

ssh_allow_empty_password () {
	true
}

license_create_manifest() {
}

do_openvision_chwon_root_image(){
   chown -R root:root ${IMAGE_ROOTFS}
}

ROOTFS_POSTPROCESS_COMMAND_append = " \
  rootfs_removeopkgleftovers; \
  rootfs_speedup_dropbearkey; \
  do_openvision_chwon_root_image; \
"
